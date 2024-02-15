package com.softeem.iov.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softeem.iov.entity.Device;

import java.util.List;

public interface DeviceService extends IService<Device> {
    //获取所有设备
    public List<Device> getAllDevice();

    //获取所有维修设备
    public List<Device> getAllRepairDevice();
}
