package com.example.webtestdemo.dao;

import com.example.webtestdemo.dao.entity.DateEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface DateEntityMapper {

    int insert(DateEntity dateEntity);

    int deletebyid(DateEntity dateEntity);

//    按照日期排序
    List<DateEntity> orderDate(DateEntity dateEntity);

}
