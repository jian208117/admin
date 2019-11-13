package com.log4j2.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.log4j2.admin.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author jian
 * @since 2019-08-09
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    //分页
    List<SysUser> getUserList();
    //统计
    Integer queryUserCount();
    //批量删除
    void deleteList(String[] idsStr);
    //批量停用
    void updateStatusOff(String[] idsStr);
    //批量启用
    void updateStatusOn(String[] idsStr);
    //根据用户名查询用户
    SysUser findByUserName(String userName);
    //根据用户id查询用户
    SysUser findByUserId(String userId);
    //分配角色
    int assignRole(@Param("userId") String userId, @Param("roles") String[] roles);




}
