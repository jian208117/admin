package com.log4j2.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
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
    //用户列表
    List<SysUser> getUserList();
    //用户总数
    Integer queryUserCount();
    //批量删除
    void deleteList(String[] idsStr);
    //批量停用
    void updateStatusOff(String[] idsStr);
    //批量启用
    void updateStatusOn(String[] idsStr);

   List<SysUser> selectUsers(String userName);

}
