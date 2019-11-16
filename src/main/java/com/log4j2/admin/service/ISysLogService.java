package com.log4j2.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.log4j2.admin.entity.SysLog;

import java.util.List;

/**
 * <p>
 * 日志表 服务类
 * </p>
 *
 * @author jian
 * @since 2019-11-15
 */
public interface ISysLogService extends IService<SysLog> {

    /**
     * 分页
     *
     * @return
     */
    List<SysLog> getLogList();

    /**
     * 统计
     *
     * @return
     */
    Integer queryLogCount();


}
