package com.softeem.iov.controller;

import com.softeem.iov.entity.Device;
import com.softeem.iov.service.DeviceService;
import com.softeem.iov.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeviceController {
    //获取所有设备
    @Autowired
    private DeviceService deviceService;
    @GetMapping("/getAllDevice")
    public ResponseData<List<Device>> getAllDevice(){
        List<Device> devices= deviceService.getAllDevice();
        return ResponseData.success(devices);
    }

    //获取所有维修设备
    @GetMapping("/getRepairDevice")
    public ResponseData<List<Device>> getAllRepairDevice(){
        List<Device> devices= deviceService.getAllRepairDevice();
        return ResponseData.success(devices);
    }
}
