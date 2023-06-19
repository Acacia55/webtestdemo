package com.example.webtestdemo.controller;

import com.example.webtestdemo.beans.HttpResponseEntity;
import com.example.webtestdemo.dao.entity.CallEntity;
import com.example.webtestdemo.dao.entity.DateEntity;
import com.example.webtestdemo.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8085")
public class CallController {

    @Autowired
    private CallService callService;

    @RequestMapping(value = "/addcall",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity addcall(@RequestBody CallEntity callEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = callService.insertCall(callEntity);

            if (result != 3){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("添加联系人失败");
            }
            else {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("添加联系人成功");
            }

        }catch (Exception e){

            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return httpResponseEntity;
    }

    @RequestMapping(value = "/deletecall",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity deletecall (@RequestBody CallEntity callEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = callService.deleteCallByPhone(callEntity);

            if (result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("删除联系人成功");
            }
            else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("删除联系人失败");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    @RequestMapping(value = "/ordercall",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity orderCall(@RequestBody CallEntity callEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        List<CallEntity> callEntityList = callService.orderCall(callEntity);

        if (!callEntityList.isEmpty()){
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(callEntityList);
            httpResponseEntity.setMessage("联系人排序成功");
        }
        else {
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(0);
            httpResponseEntity.setMessage("联系人排序失败");
        }
        return httpResponseEntity;
    }

}
