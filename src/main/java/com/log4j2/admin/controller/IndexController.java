package com.log4j2.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @描述: main
 * @制作人: jian
 * @时间: 2019/11/13
 */
@Controller
public class IndexController {


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
    public String sysUserAdd() {
        return "sys/user/user-add";
    }

    @GetMapping("/sysUserEdit")
    public String sysUserEdit() {
        return "sys/user/user-edit";
    }

    /**
     * 角色VIEW
     */

    @GetMapping("/sysRoleList")
    public String roleListController() {
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
}
