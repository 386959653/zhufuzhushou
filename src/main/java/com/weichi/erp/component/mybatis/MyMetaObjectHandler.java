package com.weichi.erp.component.mybatis;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Date;

/**
 * 注入公共字段自动填充
 * Created by Wewon on 2018/6/14.
 */
public class MyMetaObjectHandler extends MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object insertUsername = getFieldValByName("insertUsername", metaObject);
        if (insertUsername == null) {
            setFieldValByName("insertUsername", SecurityContextHolder.getContext().getAuthentication().getPrincipal(), metaObject);
        }

        Object insertTime = getFieldValByName("insertTime", metaObject);
        if (insertTime == null) {
            setFieldValByName("insertTime", new Date(), metaObject);
        }

        Object updateUsername = getFieldValByName("updateUsername", metaObject);
        if (updateUsername == null) {
            setFieldValByName("updateUsername", SecurityContextHolder.getContext().getAuthentication().getPrincipal(), metaObject);
        }

        Object updateTime = getFieldValByName("updateTime", metaObject);
        if (updateTime == null) {
            setFieldValByName("updateTime", new Date(), metaObject);
        }

    }

    //更新填充
    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateUsername = getFieldValByName("updateUsername", metaObject);
        if (updateUsername == null) {
            setFieldValByName("updateUsername", SecurityContextHolder.getContext().getAuthentication().getPrincipal(), metaObject);
        }

        Object updateTime = getFieldValByName("updateTime", metaObject);
        if (updateTime == null) {
            setFieldValByName("updateTime", new Date(), metaObject);
        }
    }
}
