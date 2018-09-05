package com.masterlee.controllers;

import com.alibaba.fastjson.JSON;
import com.masterlee.entity.Question;
import com.masterlee.entity.Record;
import com.masterlee.entity.User;
import com.masterlee.model.ResponseResult;
import com.masterlee.service.UserService;
import com.masterlee.tools.Common;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class AdminController {
    @Autowired
    UserService userService;

    private static String AppId = "wx5c16396035f95b8a";
    private static String AppSecret = "e224e54ff8373742d3e8894023146a49";

    @RequestMapping(value = "/test",produces = "application/json; charset=utf-8")
    @ResponseBody
    public String test(){
        Record record = new Record();
        record.setCreateTime(new Date());
        record.setOpenId("12314");
        record.setId(Common.getuuid());
        userService.insertRecord(record);
        return "helloworld";
    }
    @RequestMapping(value = "/getopenid",produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseResult getUserOpenid(@RequestParam(required = true,value = "code")String wxCode){
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


                result = new ResponseResult<>(resultString,true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping(value = "/userlogin",method = {RequestMethod.POST},produces = "application/json; charset=utf-8")
    @ResponseBody
    public ResponseResult userLogin(@RequestBody HashMap userinfo){
        ResponseResult<String> result =  new ResponseResult<String>("",false);
        try {
            String openid = userinfo.get("openid").toString();
            //这里要验证openid  从Redis查询

            User user = userService.select(openid);
            if(user == null){
                user.setAvatarUrl(userinfo.get("avatarUrl").toString());
                user.setCity(userinfo.get("city").toString());
                user.setCountry(userinfo.get("country").toString());
                user.setGender(userinfo.get("gender").toString());
                user.setProvince(userinfo.get("province").toString());
                user.setNickName(userinfo.get("nickName").toString());
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
        return  result;
        }
}
