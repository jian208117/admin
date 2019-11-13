package com.log4j2.admin.controller;


import com.github.pagehelper.PageHelper;
import com.log4j2.admin.common.result.R;
import com.log4j2.admin.common.result.RCode;
import com.log4j2.admin.entity.SysPermission;
import com.log4j2.admin.service.ISysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 权限表 前端控制器
 * </p>
 *
 * @author jian
 * @since 2019-10-17
 */
@RestController
@RequestMapping("/permission")
public class SysPermissionController {

    @Autowired
    private ISysPermissionService perService;

    /**
     * 权限分页列表
     * @param page
     * @param limit
     * @return
     */

    @RequestMapping(value = "",method = RequestMethod.GET)
    public R perList(Integer page, Integer limit){
        PageHelper.startPage(page,limit);
        List<SysPermission> perList = perService.getUserList();
        Integer count = perService.queryUserCount();
        return new R(RCode.SUCCESS,count,perList);
    }




}
