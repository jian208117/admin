package com.log4j2.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.log4j2.admin.entity.SysRole;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jian
 * @since 2019-09-02
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    /**
     * 分页
     * @return
     */
    List<SysRole> getRoleList();

    /**
     * 角色状态正常的分页
     */
    List<SysRole> getRoleStausList();
    /**
     * 统计
     * @return
     */
    Integer queryRoleCount();

    /**
     * 根据用户id查询角色
     * @param userId
     * @return
     */
    Set<SysRole> findRolesByUserId(String userId);

    /**
     * 根据角色id查询角色
     * @param roleId
     * @return
     */
    SysRole findByRoleId(String roleId);

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

}
