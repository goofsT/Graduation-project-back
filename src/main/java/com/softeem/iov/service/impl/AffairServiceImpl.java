package com.softeem.iov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softeem.iov.entity.Affair;
import com.softeem.iov.mapper.AffairMapper;
import com.softeem.iov.service.AffairService;
import org.springframework.stereotype.Service;

@Service
public class AffairServiceImpl extends ServiceImpl<AffairMapper, Affair> implements AffairService {
    @Override
    public void commitAffair(Affair affair) {
        baseMapper.insert(affair);
    }

    @Override
    public Affair selectAffairById(Integer id) {
        return baseMapper.selectById(id);
    }

    @Override
    public void deleteAffairById(Integer id) {
        baseMapper.deleteById(id);
    }

    @Override
    public void updateAffairStatusById(Integer id, String status) {
        Affair affair = new Affair();
        affair.setAffairId(id);
        affair.setStatus(status);
        baseMapper.updateById(affair);
    }
}
