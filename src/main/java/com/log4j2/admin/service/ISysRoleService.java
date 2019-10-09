package com.log4j2.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.log4j2.admin.entity.SysRole;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jian
 * @since 2019-09-02
 */
public interface ISysRoleService extends IService<SysRole> {
    //角色列表
    List<SysRole> getRoleList();
    //用户总数
    Integer queryRoleCount();

}
