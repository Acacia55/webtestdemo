package com.example.webtestdemo.service;

import com.example.webtestdemo.dao.BillEntityMapper;
import com.example.webtestdemo.dao.entity.BillEntity;
import com.example.webtestdemo.dao.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    @Autowired
    private BillEntityMapper billEntityMapper;

//    查找用户的bill

    public BillEntity seebill(BillEntity billEntity){

        BillEntity ResultBillEntity=billEntityMapper.selectBill(billEntity);

        return ResultBillEntity;

    }

//   写收入和支出
    public int insertBill(BillEntity billEntity){

        int result = billEntityMapper.insert(billEntity);

        return result;
    }


}
