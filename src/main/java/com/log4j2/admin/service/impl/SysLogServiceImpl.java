package com.log4j2.admin.service.impl;

import com.log4j2.admin.entity.SysLog;
import com.log4j2.admin.mapper.SysLogMapper;
import com.log4j2.admin.service.ISysLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author jian
 * @since 2019-11-15
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {


    @Autowired
    private SysLogMapper logMapper;

    @Override
    public List<SysLog> getLogList() {
        return this.logMapper.getLogList();
    }

    @Override
    public Integer queryLogCount() {
        return this.logMapper.queryLogCount();
    }
}
