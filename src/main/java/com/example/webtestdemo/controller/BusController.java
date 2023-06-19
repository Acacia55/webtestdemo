package com.example.webtestdemo.controller;

import com.example.webtestdemo.beans.HttpResponseEntity;
import com.example.webtestdemo.dao.entity.BusEntity;
import com.example.webtestdemo.dao.entity.CallEntity;
import com.example.webtestdemo.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:8085")
public class BusController {

    @Autowired
    private BusService busService;

    @RequestMapping(value = "/addbus",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity addbus(@RequestBody BusEntity busEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = busService.addBus(busEntity);

            if (result != 3){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("预约校车失败");
            }
            else {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("预约校车成功");
            }

        }catch (Exception e){

            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return httpResponseEntity;
    }

}
