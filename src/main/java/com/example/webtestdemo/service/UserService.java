package com.example.webtestdemo.service;

import com.example.webtestdemo.dao.UserEntityMapper;
import com.example.webtestdemo.dao.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserEntityMapper userEntityMapper;

    public UserEntity selectuserinfo(UserEntity userEntity){

        UserEntity ResultuserEntity=userEntityMapper.selectUserInfo(userEntity);

        return ResultuserEntity;
    }

}
