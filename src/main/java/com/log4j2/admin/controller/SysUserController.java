package com.log4j2.admin.controller;


import com.github.pagehelper.PageHelper;
import com.log4j2.admin.common.result.R;
import com.log4j2.admin.common.result.RCode;
import com.log4j2.admin.entity.SysUser;
import com.log4j2.admin.entity.SysUserRole;
import com.log4j2.admin.log.SysLog;
import com.log4j2.admin.service.ISysUserService;
import com.log4j2.admin.shiro.ShiroRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author jian
 * @since 2019-08-09
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private ISysUserService userService;



    /**
     * 用户分页列表
     *
     * @param page
     * @param limit
     * @return
     */
    @SysLog("获取用户分页")
    @RequiresPermissions("user:list")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public R userList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);

        List<SysUser> userList = userService.getUserList();
        Integer count = userService.queryUserCount();
        return new R(RCode.SUCCESS, count, userList);
    }

    /**
     * 用户增加
     *
     * @param sysUser
     * @return
     */
    @SysLog("增加用户")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public R addUser(SysUser sysUser) {
        userService.addUser(sysUser);
        //添加成功之后 清除缓存
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) securityManager.getRealms().iterator().next();
        //清除权限 相关的缓存
        shiroRealm.clearAllCache();
        return new R(RCode.SUCCESS);
    }

    /**
     * 用户更新
     *
     * @param id
     * @param sysUser
     * @return
     */
    @SysLog("更新用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public R updateUser(@PathVariable String id, SysUser sysUser) {
        sysUser.setUpdateTime(new Date());
        sysUser.setId(id);
        String password = new Md5Hash(sysUser.getPassword(), sysUser.getUserName(), 1024).toString();
        sysUser.setPassword(password);
        userService.updateById(sysUser);
        //添加成功之后 清除缓存
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) securityManager.getRealms().iterator().next();
        //清除权限 相关的缓存
        shiroRealm.clearAllCache();
        return new R(RCode.SUCCESS);
    }


    /**
     * 用户删除
     *
     * @param id
     * @return
     */
    @SysLog("删除用户")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public R deleteUser(@PathVariable String id) {

        userService.removeById(id);
        //添加成功之后 清除缓存
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) securityManager.getRealms().iterator().next();
        //清除权限 相关的缓存
        shiroRealm.clearAllCache();
        return new R(RCode.SUCCESS);
    }

    /**
     * 批量删除
     *
     * @param idsStr
     * @return
     */
    @SysLog("批量删除用户")
    @RequestMapping(value = "/deleteIds", method = RequestMethod.DELETE)
    public R deleteUserIds(String[] idsStr) {

        userService.deleteList(idsStr);
        //添加成功之后 清除缓存
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) securityManager.getRealms().iterator().next();
        //清除权限 相关的缓存
        shiroRealm.clearAllCache();
        return new R(RCode.SUCCESS);
    }

    /**
     * 批量停用
     *
     * @param idsStr
     * @return
     */
    @SysLog("批量停用用户")
    @RequestMapping(value = "/updateIdsOff", method = RequestMethod.PUT)
    public R updateIdsOff(String[] idsStr) {

        userService.updateStatusOff(idsStr);
        //添加成功之后 清除缓存
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) securityManager.getRealms().iterator().next();
        //清除权限 相关的缓存
        shiroRealm.clearAllCache();
        return new R(RCode.SUCCESS);
    }

    /**
     * 批量启用
     *
     * @param idsStr
     * @return
     */
    @SysLog("批量启用用户")
    @RequestMapping(value = "/updateIdsOn", method = RequestMethod.PUT)
    public R updateIdsOn(String[] idsStr) {

        userService.updateStatusOn(idsStr);
        //添加成功之后 清除缓存
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) securityManager.getRealms().iterator().next();
        //清除权限 相关的缓存
        shiroRealm.clearAllCache();
        return new R(RCode.SUCCESS);
    }

    /**
     * 为当前用户增加角色
     * @param id
     * @param idsStr
     * @return
     */
    @RequestMapping(value = "/assignRoles", method = RequestMethod.POST)
    public R assignRoles( String id, String[] idsStr) {

        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setCreateTime(new Date());
        userService.addRoleToUser(id, idsStr);
        return new R(RCode.SUCCESS);
    }

    /**
     * 重置当前用户密码为123456
     *
     * @param id
     * @return
     */
    @SysLog("重置用户密码")
    @RequestMapping(value = "/resetPwd/{id}", method = RequestMethod.PUT)
    public R resetPwd(@PathVariable String id) {
        SysUser sysUser = userService.getById(id);
        String password = new Md5Hash("123456", sysUser.getUserName(), 1024).toString();
        //初始密码1234546
        userService.resetByUserId(password, id);
        return new R(RCode.SUCCESS);
    }


}
