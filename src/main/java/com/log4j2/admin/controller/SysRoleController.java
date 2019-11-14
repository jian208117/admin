package com.log4j2.admin.controller;


import com.github.pagehelper.PageHelper;
import com.log4j2.admin.common.result.R;
import com.log4j2.admin.common.result.RCode;
import com.log4j2.admin.entity.SysRole;
import com.log4j2.admin.service.ISysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jian
 * @since 2019-09-02
 */
@RestController
@RequestMapping("/role")
public class SysRoleController {

    @Autowired
    private ISysRoleService roleService;

    /**
     * 角色分页列表
     *
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public R roleList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);
        List<SysRole> roleList = roleService.getRoleList();
        Integer count = roleService.queryRoleCount();
        return new R(RCode.SUCCESS, count, roleList);
    }

    /**
     * 角色增加
     *
     * @param sysRole
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public R addRole(SysRole sysRole) {
        sysRole.setCreateTime(new Date());
        roleService.save(sysRole);
        return new R(RCode.SUCCESS);
    }


    /**
     * 角色更新
     *
     * @param id
     * @param sysRole
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public R updateRole(@PathVariable String id, SysRole sysRole) {
        sysRole.setUpdateTime(new Date());
        sysRole.setId(id);
        roleService.updateById(sysRole);
        return new R(RCode.SUCCESS);
    }


    /**
     * 角色删除
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public R deleteRole(@PathVariable String id) {
        roleService.removeById(id);
        return new R(RCode.SUCCESS);
    }


    /**
     * 批量删除
     *
     * @param idsStr
     * @return
     */
    @RequestMapping(value = "/deleteIds", method = RequestMethod.DELETE)
    public R deleteRoleIds(String[] idsStr) {
        roleService.deleteList(idsStr);
        return new R(RCode.SUCCESS);
    }

    /**
     * 批量停用
     *
     * @param idsStr
     * @return
     */
    @RequestMapping(value = "/updateIdsOff", method = RequestMethod.PUT)
    public R updateIdsOff(String[] idsStr) {
        roleService.updateStatusOff(idsStr);
        return new R(RCode.SUCCESS);
    }

    /**
     * 批量启用
     *
     * @param idsStr
     * @return
     */
    @RequestMapping(value = "/updateIdsOn", method = RequestMethod.PUT)
    public R updateIdsOn(String[] idsStr) {
        roleService.updateStatusOn(idsStr);
        return new R(RCode.SUCCESS);
    }

}
