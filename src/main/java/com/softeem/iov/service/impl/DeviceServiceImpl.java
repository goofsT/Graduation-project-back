package com.softeem.iov.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softeem.iov.auth.UserUtils;
import com.softeem.iov.entity.Device;
import com.softeem.iov.mapper.DeviceMapper;
import com.softeem.iov.service.AffairService;
import com.softeem.iov.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {
    private AffairService affairService;
    @Autowired
    public DeviceServiceImpl(@Lazy AffairService affairService) {
        this.affairService = affairService;
    }
    @Override
    public List<Device> getAllDevice() {
        List device= baseMapper.selectList(null);
        return device;
    }

    @Override
    public List<Device> getAllRepairDevice() {
        //deviceStatus=1表示设备维修中
        LambdaQueryWrapper<Device> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Device::getDeviceStatus, 2); // 指定test字段等于1的条件

        // 使用IService的list方法执行查询
        return baseMapper.selectList(queryWrapper);
    }

    @Override
    public Boolean updateStatus(Integer deviceId,String deviceStatus) {
        Device device = this.selectDeviceById(deviceId);
        String oldStatus=device.getDeviceStatus();
        if(device!=null){
            device.setDeviceStatus(deviceStatus);
            Integer result=baseMapper.updateById(device);
            if(result>0) {
                if(oldStatus.equals("2")&& !deviceStatus.equals("2")){
                    Integer userId= UserUtils.getUserInfo();
                    if(userId!=null){
                        affairService.commitAffair(userId,device.getDeviceName()+"设备维修完成","0",deviceId);
                    }
                }
               if(deviceStatus.equals("2")){
                   Integer userId= UserUtils.getUserInfo();
                   if(userId!=null){
                          affairService.commitAffair(userId,device.getDeviceName()+"设备需要维修","0",deviceId);
                   }
               }
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public Boolean deleteDevice(Integer deviceId) {
        Device d=this.getById(deviceId);
        Integer result=baseMapper.deleteById(deviceId);
        if(result>0) {
            Integer userId= UserUtils.getUserInfo();
            if(userId!=null){
                affairService.commitAffair(userId,d.getDeviceName()+"设备被删除","0",deviceId);
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Device selectDeviceById(Integer deviceId) {
        Device device= baseMapper.selectById(deviceId);
        if(device!=null){
            return device;
        }else{
            return null;
        }
    }
}
