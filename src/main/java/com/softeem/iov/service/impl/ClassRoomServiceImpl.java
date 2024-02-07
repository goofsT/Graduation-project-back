package com.softeem.iov.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.softeem.iov.entity.ClassRoom;
import com.softeem.iov.mapper.ClassRoomMapper;
import com.softeem.iov.service.ClassRoomService;
import org.springframework.stereotype.Service;

@Service
public class ClassRoomServiceImpl extends ServiceImpl<ClassRoomMapper, ClassRoom> implements ClassRoomService {
}
