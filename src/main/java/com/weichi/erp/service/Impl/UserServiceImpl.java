package com.weichi.erp.service.Impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.weichi.erp.dao.TBlogMapper;
import com.weichi.erp.dao.UserDao;
import com.weichi.erp.domain.TBlog;
import com.weichi.erp.domain.User;
import com.weichi.erp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Wewon on 2018/5/18 16:53
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserDao userDao;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private TBlogMapper tBlogMapper;

    @Override
    public TBlog findAllUser() {
        return tBlogMapper.selectByPrimaryKey(1);
    }

    @Override
    public Page<TBlog> getPage() {
        Page<TBlog> page = new Page<TBlog>(1, 1);
        TBlog tBlog = new TBlog();
        tBlog.setBlogId(1);
        page.setRecords(tBlogMapper.getPage(page, tBlog));
        return page;
    }


}
