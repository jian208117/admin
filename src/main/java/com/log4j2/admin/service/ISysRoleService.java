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
    /**
     * 角色列表
     * @return
     */
    List<SysRole> getRoleList();

    /**
     * 角色状态正常列表
     * @return
     */

    List<SysRole> getRoleStausList();
    /**
     * 角色总数
     * @return
     */
    Integer queryRoleCount();

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
