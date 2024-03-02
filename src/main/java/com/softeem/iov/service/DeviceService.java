package com.softeem.iov.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.softeem.iov.entity.Device;

import java.util.List;

public interface DeviceService extends IService<Device> {
    //获取所有设备
    public List<Device> getAllDevice();

    //获取所有维修设备
    public List<Device> getAllRepairDevice();

    //更新设备状态
    public Boolean updateStatus(Integer deviceId,String deviceStatus);

    //删除设备
    public Boolean deleteDevice(Integer deviceId);

    //根据id查询设备
    public Device selectDeviceById(Integer deviceId);
}
