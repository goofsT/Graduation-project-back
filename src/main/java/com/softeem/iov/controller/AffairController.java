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
import java.util.List;

@RestController
public class AffairController {
    @Autowired
    private AffairService affairService;

    @GetMapping("/getAffair")
    public ResponseData<List<Affair>> getAffair(){
        List<Affair> affairList = affairService.list();
        if(affairList == null){
            return ResponseData.error(500, "查询失败");
        }else if(affairList.size() == 0){
            return ResponseData.error(500, "查询结果为空");
        }
        return ResponseData.success(affairList);
    }

//    @PostMapping("/commitAffair")
//    public ResponseData<User> commitAffair(@Valid @RequestBody Affair affair){
//        affairService.commitAffair(affair);
//        return ResponseData.success(null);
//    }

    @PostMapping("/updateAffairStatus")
    public ResponseData<User> updateAffair(){
        return ResponseData.success(null);
    }

}
