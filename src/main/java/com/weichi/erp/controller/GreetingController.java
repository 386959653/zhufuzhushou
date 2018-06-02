package com.weichi.erp.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.weichi.erp.domain.TBlog;
import com.weichi.erp.domain.User;
import com.weichi.erp.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Wewon on 2018/5/15 10:21
 */
@RestController
public class GreetingController {
    @Autowired
    private IUserService service;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/hello2")
    public String index() {
        logger.info("hello world");
//        return "Greetings from Spring Boot!";
        return service.selectById(1).toString();
    }

    @RequestMapping("/userList")
    public Page<TBlog> getUserList() {

        return service.getPage();
    }
}
