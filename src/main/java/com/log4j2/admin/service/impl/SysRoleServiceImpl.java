package com.log4j2.admin.service.impl;

import com.log4j2.admin.entity.SysRole;
import com.log4j2.admin.mapper.SysRoleMapper;
import com.log4j2.admin.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jian
 * @since 2019-09-02
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {


    @Autowired
    private SysRoleMapper roleMapper;

    @Override
    public List<SysRole> getRoleList() {
        return this.roleMapper.getRoleList();
    }

    @Override
    public Integer queryRoleCount() {
        return this.roleMapper.queryRoleCount();
    }
}
