package com.weichi.erp.domain;

import com.baomidou.mybatisplus.activerecord.Model;

import java.io.Serializable;

/**
 * 实体父类
 * Created by Wewon on 2018/6/7.
 */
public class SuperDomain<T extends Model> extends Model<T> {
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
