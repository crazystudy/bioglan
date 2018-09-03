package com.masterlee.mapper;

import com.masterlee.entity.Record;

public interface RecordMapper {
    int insert(Record record);

    int insertSelective(Record record);
}