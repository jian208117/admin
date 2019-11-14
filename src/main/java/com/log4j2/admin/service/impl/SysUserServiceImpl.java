package com.log4j2.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.log4j2.admin.common.result.R;
import com.log4j2.admin.common.result.RCode;
import com.log4j2.admin.common.utils.IPUtil;
import com.log4j2.admin.entity.SysUser;
import com.log4j2.admin.mapper.SysRoleMapper;
import com.log4j2.admin.mapper.SysUserMapper;
import com.log4j2.admin.service.ISysUserService;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public R addUser(SysUser sysUser) {
        //创建更新时间
        sysUser.setCreateTime(new Date());
        String password = new Md5Hash("123456",sysUser.getUserName(),1024).toString();
        //初始密码1234546
        sysUser.setPassword(password);
        sysUser.setAvatar("https://wx4.sinaimg.cn/mw1024/5db11ff4gy1fmx4keaw9pj20dw08caa4.jpg");
        sysUser.setIp(IPUtil.getCityInfo("220.248.12.150"));
        userMapper.insert(sysUser);
        return new R(RCode.SUCCESS);
    }

    @Override
    public void addRoleToUser(String userId, String[] roleIds) {

        for(String roleId:roleIds){
            userMapper.addRoleToUser(userId,roleId);
        }

    }

    @Override
    public void resetByUserId(String password, String userId) {
        this.userMapper.resetByUserId(password,userId);
    }


}
