package com.log4j2.admin.service.impl;

import com.log4j2.admin.entity.SysRole;
import com.log4j2.admin.mapper.SysRoleMapper;
import com.log4j2.admin.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jian
 * @since 2019-09-02
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {


    @Autowired
    private SysRoleMapper roleMapper;

    /**
     * 角色列表
     * @return
     */
    @Override
    public List<SysRole> getRoleList() {
        return this.roleMapper.getRoleList();
    }

    /**
     * 角色总数
     * @return
     */
    @Override
    public Integer queryRoleCount() {
        return this.roleMapper.queryRoleCount();
    }

    /**
     * 批量删除
     * @param idsStr
     */
    @Override
    public void deleteList(String[] idsStr) {
        this.roleMapper.deleteList(idsStr);
    }

    /**
     * 批量停用
     * @param idsStr
     */
    @Override
    public void updateStatusOff(String[] idsStr) {
        this.roleMapper.updateStatusOff(idsStr);
    }

    /**
     * 批量启用
     * @param idsStr
     */
    @Override
    public void updateStatusOn(String[] idsStr) {
        this.roleMapper.updateStatusOn(idsStr);
    }
}
