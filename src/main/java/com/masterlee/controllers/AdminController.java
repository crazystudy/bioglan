package com.masterlee.controllers;

import com.alibaba.fastjson.JSON;
import com.masterlee.entity.Question;
import com.masterlee.entity.Record;
import com.masterlee.entity.Score;
import com.masterlee.entity.User;
import com.masterlee.model.ResponseResult;
import com.masterlee.service.UserService;
import com.masterlee.tools.Common;
import com.masterlee.tools.RedisUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;


import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class AdminController {
    @Autowired
    UserService userService;

    private static String AppId = "wx5c16396035f95b8a";
    private static String AppSecret = "e224e54ff8373742d3e8894023146a49";

    private  static  Jedis jedis = new Jedis("localhost",6379);
    @RequestMapping(value = "/test",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String  test(){
        ResponseResult<String> result =  new ResponseResult<String>("helloworld",false);
        Record record = new Record();
        record.setCreateTime(new Date());
        record.setOpenId("12314");
        record.setId(Common.getuuid());
        userService.insertRecord(record);
        jedis.set("test","test");
        jedis.close();
        //RedisUtil.set("test","test");
        return JSON.toJSONString(result) ;
    }
    @RequestMapping(value = "/getopenid",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getUserOpenid(@RequestParam(required = true,value = "code")String wxCode){
        ResponseResult<String> result =  new ResponseResult<String>(null,false);
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="+AppId+"&secret="+AppSecret+"&js_code="+wxCode+"&grant_type=authorization_code";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String resultString = "";
        CloseableHttpResponse response = null;
        try {
            URIBuilder builder = new URIBuilder(requestUrl);
            URI uri = builder.build();
            // 创建http GET请求
            HttpGet httpGet = new HttpGet(uri);
            // 执行请求
            response = httpclient.execute(httpGet);
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                String  responsestr = EntityUtils.toString(response.getEntity(), "UTF-8");
                Map mapTypes = JSON.parseObject(responsestr);
                resultString = mapTypes.get("openid").toString();
                //取到openID 要存入Redis
               jedis.set(resultString,"login");
                jedis.close();
//                RedisUtil.incr(resultString);
//                long count =  Long.parseLong(RedisUtil.get(resultString)) ;
                result = new ResponseResult<>(resultString,true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return JSON.toJSONString(result);
    }
    @RequestMapping(value = "/userlogin",method = {RequestMethod.POST},produces = "application/json; charset=utf-8")
    @ResponseBody
    public String userLogin(@RequestBody HashMap userinfo){
        ResponseResult<String> result =  new ResponseResult<String>("",false);
        try {
            String openid = userinfo.get("openid").toString();
            //这里要验证openid  从Redis查询
            String count  = RedisUtil.get(openid);
            if (count ==null){
                return  JSON.toJSONString(result);
            }
            User user = userService.select(openid);
            if(user == null){
                user = new User();
                user.setAvatarUrl(userinfo.get("avatarUrl").toString());
                user.setCity(userinfo.get("city").toString());
                user.setCountry(userinfo.get("country").toString());
                user.setGender(userinfo.get("gender").toString());
                user.setProvince(userinfo.get("province").toString());
                user.setNickName(userinfo.get("nickName").toString());
                user.setOpenId(openid);
                userService.insert(user);
            }
            Record record = new Record();
            record.setCreateTime(new Date());
            record.setOpenId(openid);
            record.setId(Common.getuuid());
            userService.insertRecord(record);
            result = new ResponseResult<String>("",true);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  JSON.toJSONString(result);
    }
    @RequestMapping(value = "/checkcount",method = {RequestMethod.GET},produces = "application/json; charset=utf-8")
    @ResponseBody
    public String checkCount(@RequestParam(required = true,value = "openid")String openid){
        ResponseResult<String> result =  new ResponseResult<String>("",true);
        String count =  RedisUtil.get("Count:"+openid);
        if (count ==null) {
            return  JSON.toJSONString(result);
        }
         if(Long.parseLong(count)>2){
             result.setResponseData("您的答题机会已用完");
             result.setResponseStatus(false);
             return  JSON.toJSONString(result);
         }
        return  JSON.toJSONString(result);
    }
    @RequestMapping(value = "/getquestion",method = {RequestMethod.GET},produces = "application/json; charset=utf-8")
    @ResponseBody
    public String checkCount(){
        ResponseResult<Question> result =  new ResponseResult(null,false);
        try {
            List<Question>  list  = userService.selectQuestion();
            result =  new ResponseResult(list,list.size(),true);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  JSON.toJSONString(result);
    }
    @RequestMapping(value = "/uploadscore",method ={RequestMethod.POST}, produces = "application/json; charset=utf-8")
    @ResponseBody
    public  String uploadScore(@RequestBody HashMap request){
        ResponseResult<String> result =  new ResponseResult(null,false);
        try {
            String  openid = request.get("openid").toString();
            Score entity = new Score();
            entity.setCreateTime(new Date());
            entity.setId(Common.getuuid());
            entity.setScore(Integer.parseInt(request.get("score").toString()));
            entity.setTime(Integer.parseInt(request.get("time").toString()));
            entity.setOpenId(openid);
            userService.insertScore(entity);
            RedisUtil.incr("Count:"+openid);
            result = new ResponseResult<String>("添加成功",true);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  JSON.toJSONString(result);
    }
    @RequestMapping(value = "/uploaduser",method ={RequestMethod.POST},produces = "application/json; charset=utf-8")
    @ResponseBody
    public  String uploadUser(@RequestBody HashMap request){
        ResponseResult<String> result =  new ResponseResult(null,false);
        try {
            String  openid = request.get("openid").toString();
            User user = userService.select(openid);
            if (user !=null){
                user.setRealName(request.get("name").toString());
                user.setPhone(request.get("phone").toString());
                userService.update(user);
                result = new ResponseResult<String>("添加成功",true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  JSON.toJSONString(result);
    }
}
