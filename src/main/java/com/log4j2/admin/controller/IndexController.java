package com.log4j2.admin.controller;

import com.log4j2.admin.entity.SysRole;
import com.log4j2.admin.service.ISysRoleService;
import com.log4j2.admin.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @描述: main
 * @制作人: jian
 * @时间: 2019/11/13
 */
@Controller
public class IndexController {

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysRoleService roleService;

    /**
     * 系统VIEW
     * @param request
     * @return
     */
    @GetMapping("/login")
    public String loginController(HttpServletRequest request) {
        request.setAttribute("loginTitle", "Jian-Admin-登录");
        return "login";
    }

    @GetMapping("/index")
    public String index(HttpServletRequest request) {
        request.setAttribute("indexTitle", "Jian-Admin");
        return "index";
    }

    @GetMapping("/")
    public String syController() {
        return "index";
    }

    @GetMapping("/403")
    public String unauthorized() {
        return "403";
    }

    @GetMapping("/404")
    public String undeifind() {
        return "404";
    }

    @GetMapping("/500")
    public String sysError() {
        return "500";
    }


    /**
     * 用户VIEW
     */

    @GetMapping("/sysUserList")
    public String userListController() {
        return "sys/user/user";
    }

    @GetMapping("/sysUserAdd")
    public String sysUserAdd(HttpServletRequest request) {
        return "sys/user/user-add";
    }

    @GetMapping("/sysUserEdit")
    public String sysUserEdit() {
        return "sys/user/user-edit";
    }

    @GetMapping("/sysUserAddRole")
    public String sysUserAddRole(HttpServletRequest request,@RequestParam String userId) {
        List<SysRole> roleList = this.roleService.getRoleStausList();
        request.setAttribute("roleList", roleList);
        return "sys/user/userAddRole";
    }

    /**
     * 角色VIEW
     */

    @GetMapping("/sysRoleList")
    public String sysRoleList() throws Exception {

        return "sys/role/role";
    }

    @GetMapping("/sysRoleAdd")
    public String sysRoleAdd() {
        return "sys/role/role-add";
    }

    @GetMapping("/sysRoleEdit")
    public String sysRoleEdit() {
        return "sys/role/role-edit";
    }

    /**
     * 日志VIES
     */
    @GetMapping("/sysLogList")
    public String syLogList() {
        return "sys/log/log";
    }
}
