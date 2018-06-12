package com.weichi.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Wewon on 2018/5/29 11:06
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String freemarker(@RequestParam(value = "error", required = false) String error, Map<String, Object> map) {
        if (error != null) {
            map.put("error", "error");
        }
        return "login";
    }


}
