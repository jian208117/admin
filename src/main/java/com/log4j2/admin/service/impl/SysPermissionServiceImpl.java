package com.log4j2.admin.service.impl;

import com.log4j2.admin.entity.SysPermission;
import com.log4j2.admin.mapper.SysPermissionMapper;
import com.log4j2.admin.service.ISysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author jian
 * @since 2019-10-17
 */
@Service
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionMapper, SysPermission> implements ISysPermissionService {

    @Autowired
    private SysPermissionMapper perMapper;


    @Override
    public List<SysPermission> getUserList() {
        return  this.perMapper.getUserList();
    }

    @Override
    public Integer queryUserCount() {
        return this.perMapper.queryUserCount();
    }
}
