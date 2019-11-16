package com.log4j2.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.log4j2.admin.entity.SysLog;

import java.util.List;

/**
 * <p>
 * 日志表 Mapper 接口
 * </p>
 *
 * @author jian
 * @since 2019-11-15
 */
public interface SysLogMapper extends BaseMapper<SysLog> {

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
