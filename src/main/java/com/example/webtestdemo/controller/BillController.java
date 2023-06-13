package com.example.webtestdemo.controller;

import com.example.webtestdemo.beans.HttpResponseEntity;
import com.example.webtestdemo.dao.entity.BillEntity;
import com.example.webtestdemo.dao.entity.UserEntity;
import com.example.webtestdemo.service.BillService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8085")
//@RequestMapping("/admin")
public class BillController {

    private BillService billService;

//    查看用户的bill
@RequestMapping(value = "/seebill",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity seeBill(@RequestBody BillEntity billEntity){
    HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
    try {
        BillEntity hasbill = billService.seebill(billEntity);

        if (hasbill == null){
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(0);
            httpResponseEntity.setMessage("用户名或密码错误");
        }
        else {
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(hasbill);
            httpResponseEntity.setMessage("登陆成功");
        }

    }catch (Exception e){

        System.out.println(e.getMessage());
        e.printStackTrace();

    }
    return httpResponseEntity;
    }

}