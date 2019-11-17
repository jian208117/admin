package com.log4j2.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.log4j2.admin.common.result.R;
import com.log4j2.admin.entity.SysUser;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author jian
 * @since 2019-08-09
 */
public interface ISysUserService extends IService<SysUser> {
    /**
     * 用户列表
     *
     * @return
     */
    List<SysUser> getUserList();

    /**
     * 用户总数
     *
     * @return
     */
    Integer queryUserCount();

    /**
     * 批量删除
     *
     * @param idsStr
     */
    void deleteList(String[] idsStr);

    /**
     * 批量停用
     *
     * @param idsStr
     */
    void updateStatusOff(String[] idsStr);

    /**
     * 批量启用
     *
     * @param idsStr
     */
    void updateStatusOn(String[] idsStr);

    /**
     * 增加用户
     *
     * @param sysUser
     * @return
     */
    R addUser(SysUser sysUser);

    void addRoleToUser(String userId, String[] roleIds);

    /**
     * 重置密码
     *
     * @param password
     * @param userId
     */
    void resetByUserId(String password, String userId);

    /**
     * 根据id查询用户
     * @param userId
     * @return
     */
    SysUser findByUserId(String userId);


}
