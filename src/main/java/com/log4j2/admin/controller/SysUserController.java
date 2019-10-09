package com.log4j2.admin.controller;


import com.github.pagehelper.PageHelper;
import com.log4j2.admin.common.result.R;
import com.log4j2.admin.common.result.RCode;
import com.log4j2.admin.common.utils.IPUtil;
import com.log4j2.admin.entity.SysUser;
import com.log4j2.admin.service.ISysUserService;
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
     * @param page
     * @param limit
     * @return
     */
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
        //sysUser.setStatus("0");
        sysUser.setCreateTime(new Date());
        sysUser.setAvatar("https://wx4.sinaimg.cn/mw1024/5db11ff4gy1fmx4keaw9pj20dw08caa4.jpg");
        sysUser.setIp(IPUtil.getCityInfo("220.248.12.150"));
        userService.save(sysUser);
        return new R(RCode.SUCCESS);
    }

    /**
     * 用户更新
     * @param userId
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/{userId}",method = RequestMethod.PUT)
    public R updateUser(@PathVariable String userId,  SysUser sysUser){
        sysUser.setUpdateTime(new Date());
        sysUser.setUserId(userId);
        userService.updateById(sysUser);
        return new R(RCode.SUCCESS);
    }


    /**
     * 用户删除
     * @param userId
     * @return
     */
    @RequestMapping(value = "/{userId}",method = RequestMethod.DELETE)
    public R deleteUser(@PathVariable String userId){

        userService.removeById(userId);
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
        return new R(RCode.SUCCESS);
    }


    /**
     * 分配角色
     */









}
