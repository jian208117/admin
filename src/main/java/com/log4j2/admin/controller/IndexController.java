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


    @GetMapping("/sys/adminList")
    public String userListController() {
        return "sys/user/user";
    }
    /**
     * 跳转到无权限页面
     *
     * @return
     */
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

    @GetMapping("/sysUser")
    public String sysUser() {
        return "/pages/member/user";
    }
}
