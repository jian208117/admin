package com.log4j2.admin.controller;


import com.github.pagehelper.PageHelper;
import com.log4j2.admin.common.result.R;
import com.log4j2.admin.common.result.RCode;
import com.log4j2.admin.entity.SysLog;
import com.log4j2.admin.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 日志表 前端控制器
 * </p>
 *
 * @author jian
 * @since 2019-11-15
 */
@RestController
@RequestMapping("/log")
public class SysLogController {


    @Autowired
    private ISysLogService logService;

    /**
     * 日志分页列表
     *
     * @param page
     * @param limit
     * @return
     */
    @com.log4j2.admin.log.SysLog("获取日志分页")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public R logList(Integer page, Integer limit) {
        PageHelper.startPage(page, limit);

        List<SysLog> logList = logService.getLogList();
        Integer count = logService.queryLogCount();
        return new R(RCode.SUCCESS, count, logList);
    }

}
