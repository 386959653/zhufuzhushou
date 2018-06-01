package com.weichi.erp.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.weichi.erp.domain.TBlog;
import com.weichi.erp.domain.User;

import java.util.List;

/**
 * Created by Wewon on 2018/5/18 16:50
 */
public interface IUserService {
    /**
     * 查询用户列表
     *
     * @return
     */
    public TBlog findAllUser();

    public Page<TBlog> getPage();
}
