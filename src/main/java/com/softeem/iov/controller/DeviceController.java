package com.softeem.iov.controller;

import com.softeem.iov.entity.Device;
import com.softeem.iov.service.DeviceService;
import com.softeem.iov.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //设置维修设备
    @PostMapping("/updateDeviceStatus")
    public ResponseData setRepairDevice(@RequestBody Device device){
        Boolean res=deviceService.updateStatus(device.getDeviceId(),device.getDeviceStatus());
        if(res){
            return ResponseData.success(null);
        }else{
            return ResponseData.error(400,"设置失败");
        }
    }

    //删除设备
    @PostMapping("/deleteDevice")
    public ResponseData deleteDevice(@RequestBody Device device){
        Boolean res= deviceService.deleteDevice(device.getDeviceId());
        if(res){
            return ResponseData.success(null);
        }else{
            return ResponseData.error(400,"删除失败");
        }
    }

    @GetMapping("/getDeviceById")
    public ResponseData<Device> getDeviceById(@RequestParam Integer deviceId){
        Device device = deviceService.getById(deviceId);
        if(device!=null) {
            return ResponseData.success(device);
        }else{
            return ResponseData.error(400,"未查询到设备");
        }
    }
}
