package com.example.webtestdemo.dao;

import com.example.webtestdemo.dao.entity.BusEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface BusEntityMapper {

    int insert(BusEntity busEntity);

}
