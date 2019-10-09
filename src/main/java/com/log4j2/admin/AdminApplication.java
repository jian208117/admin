package com.log4j2.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@Controller
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}

	@GetMapping("/")
	public String indexController(HttpServletRequest req){
		req.setAttribute("title","Jian-Admin");
		return "index";
	}
}
