package com.example.webtestdemo.service;

import com.example.webtestdemo.dao.CallEntityMapper;
import com.example.webtestdemo.dao.entity.CallEntity;
import com.example.webtestdemo.dao.entity.DateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallService {
    @Autowired
    private CallEntityMapper callEntityMapper;

    public int insertCall(CallEntity callEntity){

        int result = callEntityMapper.insert(callEntity);

        if (result != 0){
            return 3;/*3代表ok*/
        }

        return result;
    }

    public int deleteCallByPhone(CallEntity callEntity){

        int callResult = callEntityMapper.deletebyphone(callEntity);

        if (callResult !=0){
            return 3;
        }
        return callResult;
    }

    public List<CallEntity> orderCall(CallEntity callEntity){

        return callEntityMapper.orderCallByName(callEntity);
    }

}
