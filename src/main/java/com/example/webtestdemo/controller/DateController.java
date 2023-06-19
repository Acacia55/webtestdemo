package com.example.webtestdemo.controller;

import com.example.webtestdemo.beans.HttpResponseEntity;
import com.example.webtestdemo.dao.entity.BillEntity;
import com.example.webtestdemo.dao.entity.DateEntity;
import com.example.webtestdemo.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:8085")
public class DateController {

    @Autowired
    private DateService dateService;

    @RequestMapping(value = "/adddate",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity adddate(@RequestBody DateEntity dateEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = dateService.insertDate(dateEntity);

            if (result != 3){
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("添加日程失败");
            }
            else {
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("添加日程成功");
            }

        }catch (Exception e){

            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        return httpResponseEntity;
    }

    @RequestMapping(value = "/deletedate",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity deletedate (@RequestBody DateEntity dateEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();
        try {
            int result = dateService.deleteDateById(dateEntity);

            if (result!=0){
                httpResponseEntity.setCode("666");
                httpResponseEntity.setData(result);
                httpResponseEntity.setMessage("删除日程成功");
            }
            else {
                httpResponseEntity.setCode("0");
                httpResponseEntity.setData(0);
                httpResponseEntity.setMessage("删除日程失败");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return httpResponseEntity;
    }

    @RequestMapping(value = "/orderdate",method = RequestMethod.POST,headers = "Accept=application/json")
    public HttpResponseEntity orderDate(@RequestBody DateEntity dateEntity){
        HttpResponseEntity httpResponseEntity = new HttpResponseEntity();

        List<DateEntity> orderlist = dateService.orderDate(dateEntity);

        if (!orderlist.isEmpty()){
            httpResponseEntity.setCode("666");
            httpResponseEntity.setData(orderlist);
            httpResponseEntity.setMessage("日期排序成功");
        }
        else {
            httpResponseEntity.setCode("0");
            httpResponseEntity.setData(0);
            httpResponseEntity.setMessage("日期排序失败");
        }
        return httpResponseEntity;
    }

}
