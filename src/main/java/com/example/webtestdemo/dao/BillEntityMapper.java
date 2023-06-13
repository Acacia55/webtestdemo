package com.example.webtestdemo.dao;

import com.example.webtestdemo.dao.entity.BillEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface BillEntityMapper {

//    查找该用户的bill
    BillEntity selectBill(BillEntity billEntity);

//    填写每天的收入和支出
    int insert(BillEntity billEntity);

}
