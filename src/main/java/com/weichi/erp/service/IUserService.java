package com.weichi.erp.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.weichi.erp.domain.TBlog;
import com.weichi.erp.domain.User;

import java.util.List;

/**
 * Created by Wewon on 2018/5/18 16:50
 */
public interface IUserService extends IService<User> {
    /**
     * 查询用户列表
     *
     * @return
     */
    public TBlog findAllUser();

    public Page<TBlog> getPage();
}
