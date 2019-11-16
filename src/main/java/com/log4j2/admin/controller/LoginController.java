package com.log4j2.admin.controller;

import com.log4j2.admin.common.result.R;
import com.log4j2.admin.common.result.RCode;
import com.log4j2.admin.entity.SysUser;
import com.log4j2.admin.log.SysLog;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @描述: 登录
 * @制作人: jian
 * @时间: 2019/10/17
 */
@RestController
public class LoginController {


    @SysLog("用户登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public R loginUser(String username, String password, boolean rememberMe) {

        //1.密码，盐，加密次数
        password = new Md5Hash(password,username,1024).toString();
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(username,password,rememberMe);
        Subject subject = SecurityUtils.getSubject();
        try {
            //登录操作
            subject.login(usernamePasswordToken);
            SysUser user=(SysUser) subject.getPrincipal();
            System.out.println(user);
            return new R(RCode.SUCCESS);
        } catch(Exception e) {
            //登录失败从request中获取shiro处理的异常信息 shiroLoginFailure:就是shiro异常类的全类名
            //返回登录页面
            return new R(RCode.FAIL);
        }
    }



}
