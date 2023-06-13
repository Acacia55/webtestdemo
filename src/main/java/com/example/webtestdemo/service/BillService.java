package com.example.webtestdemo.service;

import com.example.webtestdemo.dao.BillEntityMapper;
import com.example.webtestdemo.dao.entity.BillEntity;
import com.example.webtestdemo.dao.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

    @Autowired
    private BillEntityMapper billEntityMapper;

//    查找用户的bill

    public BillEntity seebill(BillEntity billEntity){

        return billEntityMapper.selectBill(billEntity);

    }

//   写收入和支出
    public int insertBill(BillEntity billEntity){

        int result = billEntityMapper.insert(billEntity);

        if (result != 0){
            return 3;/*3代表ok*/
        }

        return result;
    }

//    删除
    public int deleteBillById(BillEntity billEntity){

        int billResult = billEntityMapper.deletebyid(billEntity);

        if (billResult !=0){
            return 3;
        }
        return billResult;
    }

    public int modifyBillById(BillEntity billEntity){

        int billResult = billEntityMapper.updatebyid(billEntity);

        if (billResult !=0){
            return 3;
        }
        return billResult;
    }


}
