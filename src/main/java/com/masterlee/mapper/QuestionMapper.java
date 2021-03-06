package com.masterlee.mapper;

import com.masterlee.entity.Question;

import java.util.List;

public interface QuestionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
    List<Question> selectQuestion();
}