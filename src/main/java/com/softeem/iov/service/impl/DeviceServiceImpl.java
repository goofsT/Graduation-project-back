package com.softeem.iov.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softeem.iov.entity.Device;
import com.softeem.iov.mapper.DeviceMapper;
import com.softeem.iov.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {
    @Override
    public List<Device> getAllDevice() {
        List device= baseMapper.selectList(null);
        return device;
    }

    @Override
    public List<Device> getAllRepairDevice() {
        //deviceStatus=1表示设备维修中
        LambdaQueryWrapper<Device> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Device::getDeviceStatus, 1); // 指定test字段等于1的条件

        // 使用IService的list方法执行查询
        return baseMapper.selectList(queryWrapper);
    }
}
