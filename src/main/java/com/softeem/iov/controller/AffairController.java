package com.softeem.iov.controller;

import com.softeem.iov.auth.dtos.LoginDTO;
import com.softeem.iov.entity.Affair;
import com.softeem.iov.entity.User;
import com.softeem.iov.service.AffairService;
import com.softeem.iov.service.ClassRoomService;
import com.softeem.iov.utils.ResponseData;
import com.softeem.iov.utils.TokenResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AffairController {
    @Autowired
    private AffairService affairService;

    @GetMapping("/getAffairs")
    public ResponseData<List<Affair>> getAffair(){
        List<Affair> affairList = affairService.getAllAffairs();
        if(affairList==null){
            return ResponseData.success(new ArrayList<>(0));
        }else{
            return ResponseData.success(affairList);
        }
    }

    @GetMapping("/getTodayAffairs")
    public ResponseData<List<Affair>> getTodayAffairs(){
        List<Affair> affairList = affairService.getTodayAffairs();
        if(affairList==null){
            return ResponseData.success(new ArrayList<>(0));
        }else{
            return ResponseData.success(affairList);
        }
    }

    @PostMapping("/deleteAffair")
    public ResponseData deleteAffair(@RequestBody Affair affair){
        Boolean result=affairService.removeById(affair.getAffairId());
        if(result){
            return ResponseData.success(null);
        }else{
            return ResponseData.error(500, "删除失败");
        }
    }





    @PostMapping("/updateAffairStatus")
    public ResponseData<User> updateAffair(){
        return ResponseData.success(null);
    }

}
