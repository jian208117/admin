package com.log4j2.admin.service;

import com.log4j2.admin.entity.SysPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 权限表 服务类
 * </p>
 *
 * @author jian
 * @since 2019-10-17
 */
public interface ISysPermissionService extends IService<SysPermission> {



    List<SysPermission> getUserList();

    Integer queryUserCount();
}
