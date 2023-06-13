package com.example.webtestdemo.controller;

import com.example.webtestdemo.beans.HttpResponseEntity;
import com.example.webtestdemo.dao.entity.UserEntity;
import com.example.webtestdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8085")
//@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userLogin",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity userLogin (@RequestBody UserEntity userEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            UserEntity hasuser = userService.selectuserinfo(userEntity);

            if (hasuser == null){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("用户名或密码错误");
            }
            else {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(hasuser);
                httpResponseEntity.setMessage("登陆成功");
            }

        }catch (Exception e){

            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return httpResponseEntity;
    }

}
