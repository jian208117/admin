package com.log4j2.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.log4j2.admin.entity.SysUser;
import com.log4j2.admin.mapper.SysRoleMapper;
import com.log4j2.admin.mapper.SysUserMapper;
import com.log4j2.admin.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author jian
 * @since 2019-08-09
 */
@Service
class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysRoleMapper roleMapper;

    //用户列表
    @Override
    public List<SysUser> getUserList() {
        return this.userMapper.getUserList();
    }

    //用户总数
    @Override
    public Integer queryUserCount() {
        return this.userMapper.queryUserCount();
    }

    //批量删除
    @Override
    public void deleteList(String[] idsStr) {
        this.userMapper.deleteList(idsStr);
    }

    //批量停用
    @Override
    public void updateStatusOff(String[] idsStr) {
        this.userMapper.updateStatusOff(idsStr);
    }

    //批量启用
    @Override
    public void updateStatusOn(String[] idsStr) {
        this.userMapper.updateStatusOn(idsStr);
    }

    @Override
    public List<SysUser> selectUsers(String userName) {
        return this.userMapper.selectUsers(userName);
    }


}
