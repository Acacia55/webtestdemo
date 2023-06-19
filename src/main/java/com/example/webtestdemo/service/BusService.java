package com.example.webtestdemo.service;

import com.example.webtestdemo.dao.BusEntityMapper;
import com.example.webtestdemo.dao.entity.BusEntity;
import org.springframework.stereotype.Service;

@Service
public class BusService {

    private BusEntityMapper busEntityMapper;

    public int addBus(BusEntity busEntity){
        int result = busEntityMapper.insert(busEntity);

        if (result != 0){
            return 3;/*3代表ok*/
        }

        return result;
    }

}
