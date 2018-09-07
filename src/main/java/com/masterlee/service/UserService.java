package com.masterlee.service;

import com.masterlee.entity.Question;
import com.masterlee.entity.Record;
import com.masterlee.entity.Score;
import com.masterlee.entity.User;
import com.masterlee.mapper.QuestionMapper;
import com.masterlee.mapper.RecordMapper;
import com.masterlee.mapper.ScoreMapper;
import com.masterlee.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper  userMapper;

    @Autowired
    RecordMapper recordMapper;

    @Autowired
    QuestionMapper questionMapper;
    @Autowired
    ScoreMapper scoreMapper;

    public void  insert(User user){
        userMapper.insert(user);
    }
    public  void  update(User   user){
        userMapper.updateByPrimaryKeySelective(user);
    }
    public  User  select(String openid){
        return userMapper.selectByPrimaryKey(openid);
    }
    public  void  insertRecord(Record record){
        recordMapper.insert(record);
    }
    public List<Question> selectQuestion(){
        return  questionMapper.selectQuestion();
    }
    public void   insertScore(Score score){
        scoreMapper.insert(score);
    }
}
