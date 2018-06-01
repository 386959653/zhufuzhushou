package com.weichi.erp.dao;

import com.weichi.erp.domain.User;

import java.util.List;

/**
 * Created by Wewon on 2018/5/18 15:48
 */

public interface UserDao {
    /**
     * 查询用户列表
     *
     * @return
     */
    List<User> findAllUser();
}
