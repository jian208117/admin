package com.log4j2.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.log4j2.admin.entity.SysPermission;
import com.log4j2.admin.entity.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author jian
 * @since 2019-10-17
 */
public interface SysPermissionMapper extends BaseMapper<SysPermission> {
    //根据角色id查询权限
    Set<SysPermission> findPermissionsByRoleId(@Param("roles")Set<SysRole> roles);
    //分页
    List<SysPermission> getUserList();
    //汇总
    Integer queryUserCount();
}
