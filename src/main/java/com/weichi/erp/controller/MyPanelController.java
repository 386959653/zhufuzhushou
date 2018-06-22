package com.weichi.erp.controller;

import com.weichi.erp.domain.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * Created by Wewon on 2018/6/19.
 */
@Controller
@RequestMapping("myPanel")
public class MyPanelController {
    @RequestMapping("orderDish")
    public String orderDish(Map<String, Object> map) {
        List<Menu> menuList = new Menu().selectAll();
        map.put("menuList", menuList);
        return "myPanel/orderDish";
    }

}
