package com.log4j2.admin.controller;


import com.github.pagehelper.PageHelper;
import com.log4j2.admin.common.result.R;
import com.log4j2.admin.common.result.RCode;
import com.log4j2.admin.entity.SysUser;
import com.log4j2.admin.service.ISysUserService;
import com.log4j2.admin.shiro.ShiroRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
     * @param page
     * @param limit
     * @return
     */
    @RequiresPermissions("user:list")
    @RequestMapping(value = "",method = RequestMethod.GET)
    public R userList(Integer page, Integer limit){
        PageHelper.startPage(page,limit);

        List<SysUser> userList = userService.getUserList();
        Integer count = userService.queryUserCount();
        return new R(RCode.SUCCESS,count,userList);
    }

    /**
     * 用户增加
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    public R addUser(SysUser sysUser){
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
     * @param id
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public R updateUser(@PathVariable String id,  SysUser sysUser){
        sysUser.setUpdateTime(new Date());
        sysUser.setId(id);
        userService.updateById(sysUser);
        //添加成功之后 清除缓存
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager)SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) securityManager.getRealms().iterator().next();
        //清除权限 相关的缓存
        shiroRealm.clearAllCache();
        return new R(RCode.SUCCESS);
    }


    /**
     * 用户删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public R deleteUser(@PathVariable String id){

        userService.removeById(id);
        //添加成功之后 清除缓存
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager)SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) securityManager.getRealms().iterator().next();
        //清除权限 相关的缓存
        shiroRealm.clearAllCache();
        return new R(RCode.SUCCESS);
    }

    /**
     * 批量删除
     * @param idsStr
     * @return
     */
    @RequestMapping(value = "/deleteIds",method = RequestMethod.DELETE)
    public R deleteUserIds(String[] idsStr){

        userService.deleteList(idsStr);
        //添加成功之后 清除缓存
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager)SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) securityManager.getRealms().iterator().next();
        //清除权限 相关的缓存
        shiroRealm.clearAllCache();
        return new R(RCode.SUCCESS);
    }

    /**
     * 批量停用
     * @param idsStr
     * @return
     */
    @RequestMapping(value = "/updateIdsOff",method = RequestMethod.PUT)
    public R updateIdsOff(String[] idsStr){

        userService.updateStatusOff(idsStr);
        //添加成功之后 清除缓存
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager)SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) securityManager.getRealms().iterator().next();
        //清除权限 相关的缓存
        shiroRealm.clearAllCache();
        return new R(RCode.SUCCESS);
    }

    /**
     * 批量启用
     * @param idsStr
     * @return
     */
    @RequestMapping(value = "/updateIdsOn",method = RequestMethod.PUT)
    public R updateIdsOn(String[] idsStr){

        userService.updateStatusOn(idsStr);
        //添加成功之后 清除缓存
        DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager)SecurityUtils.getSecurityManager();
        ShiroRealm shiroRealm = (ShiroRealm) securityManager.getRealms().iterator().next();
        //清除权限 相关的缓存
        shiroRealm.clearAllCache();
        return new R(RCode.SUCCESS);
    }

    @RequestMapping(value = "/assignRoles",method = RequestMethod.PUT)
    public R assignRoles(@RequestBody Map<String, Object> map) {
        //1.获取被分配的用户id
        String userId = (String) map.get("id");
        //2.获取到角色的id列表
        List<String> roleIds = (List<String>) map.get("roleIds");
        //3.调用service完成角色分配
        userService.assignRoles(userId, roleIds);
        return new R(RCode.SUCCESS);
    }











}
