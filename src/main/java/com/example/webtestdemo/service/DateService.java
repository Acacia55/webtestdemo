package com.example.webtestdemo.service;

import com.example.webtestdemo.dao.DateEntityMapper;
import com.example.webtestdemo.dao.entity.BillEntity;
import com.example.webtestdemo.dao.entity.DateEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DateService {

    @Autowired
    private DateEntityMapper dateEntityMapper;

    public int insertDate(DateEntity dateEntity){

        int result = dateEntityMapper.insert(dateEntity);

        if (result != 0){
            return 3;/*3代表ok*/
        }

        return result;
    }

    public int deleteDateById(DateEntity dateEntity){

        int billResult = dateEntityMapper.deletebyid(dateEntity);

        if (billResult !=0){
            return 3;
        }
        return billResult;
    }

    public List<DateEntity> orderDate(DateEntity dateEntity){

        return dateEntityMapper.orderDate(dateEntity);
    }

}
