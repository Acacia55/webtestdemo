package com.example.webtestdemo.dao;

import com.example.webtestdemo.dao.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserEntityMapper {

//    查找用户
    UserEntity selectUserInfo(UserEntity userEntity);

}
