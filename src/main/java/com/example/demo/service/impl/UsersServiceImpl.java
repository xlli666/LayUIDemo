package com.example.demo.service.impl;

import com.example.demo.dao.UsersDao;
import com.example.demo.pojo.UsersDomain;
import com.example.demo.service.UsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

    private final UsersDao usersDao;

    @Autowired
    public UsersServiceImpl(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public PageInfo<UsersDomain> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UsersDomain> usersDomains = usersDao.selectUsers();
        return new PageInfo<>(usersDomains);
    }

    @Override
    public PageInfo<UsersDomain> findAllUser2(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UsersDomain> usersDomains = usersDao.selectUsersExt();
        return new PageInfo<>(usersDomains);
    }
}
