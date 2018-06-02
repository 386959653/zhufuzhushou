package com.weichi.erp.domain;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * Created by Wewon on 2018/5/18 15:49
 */
@TableName("t_user")
public class User extends Model<User> {
    @TableId("user_id")
    private String id;
    @TableField("user_name")
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
