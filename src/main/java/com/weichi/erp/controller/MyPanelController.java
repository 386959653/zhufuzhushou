package com.weichi.erp.controller;

import com.baomidou.mybatisplus.mapper.Condition;
import com.weichi.erp.component.myType.JsonResult;
import com.weichi.erp.component.springSecurity.MyUserDetails;
import com.weichi.erp.component.utils.DateUtils;
import com.weichi.erp.dao.MenuMapper;
import com.weichi.erp.domain.OrderList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Wewon on 2018/6/19.
 */
@Controller
@RequestMapping("myPanel")
public class MyPanelController {
    @Autowired
    private MenuMapper menuMapper;
    @RequestMapping("orderDish")
    public String orderDish(Map<String, Object> map) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Map<String, Object>> menuList = menuMapper.listMyMenu(userDetails.getUserId());
        map.put("menuList", menuList);
        return "myPanel/orderDish";
    }


    @ResponseBody
    @RequestMapping("orderOrCancel")
    public JsonResult<?> orderOrCancel(@RequestParam(value = "flag") String flag, @RequestParam(value = "menuId", required = false) Long menuId, @RequestParam(value = "orderListId", required = false) Long orderListId) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        JsonResult jsonResult = new JsonResult();
        OrderList orderList = new OrderList();
        if ("order".equalsIgnoreCase(flag)) {
            orderList.setUserId(userDetails.getUserId());
            orderList.setMenuId(menuId);
            int existCount = orderList.selectCount(Condition.create().eq("user_id", userDetails.getUserId()).eq("menu_id", menuId).between("insert_time", DateUtils.truncate(new Date(), Calendar.DAY_OF_MONTH), new Date()));
            if (existCount == 0) {
                orderList.insert();
                jsonResult.setData(orderList.getId().toString());
            }
        } else {
            orderList.deleteById(orderListId);
        }
        return jsonResult;
    }

}
