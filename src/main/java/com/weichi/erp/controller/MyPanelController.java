package com.weichi.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Wewon on 2018/6/19.
 */
@Controller
@RequestMapping("myPanel")
public class MyPanelController {
    @RequestMapping("show")
    public String show(Map<String, Object> map) {
        return "myPanel";
    }

}
