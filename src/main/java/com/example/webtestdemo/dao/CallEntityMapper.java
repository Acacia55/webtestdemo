package com.example.webtestdemo.dao;

import com.example.webtestdemo.dao.entity.CallEntity;
import com.example.webtestdemo.dao.entity.DateEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component
public interface CallEntityMapper {

    int insert(CallEntity callEntity);

    int deletebyphone(CallEntity callEntity);

    //    按照名称排序
    List<CallEntity> orderCallByName(CallEntity callEntity);

}
