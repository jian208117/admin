package com.log4j2.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.log4j2.admin.entity.SysRole;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jian
 * @since 2019-09-02
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    //分页
    List<SysRole> getRoleList();
    //统计
    Integer queryRoleCount();

}
