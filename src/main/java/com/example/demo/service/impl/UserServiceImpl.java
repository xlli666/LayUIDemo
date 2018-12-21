package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.pojo.UserDomain;
import com.example.demo.pojo.UserRequestParam;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public PageInfo<UserDomain> findAllUser(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserDomain> users = userDao.selectUsers();
        return new PageInfo<>(users);
    }

    @Override
    public PageInfo<UserDomain> findUsersBy(int pageNum, int pageSize, UserRequestParam userParam) {
        PageHelper.startPage(pageNum,pageSize);
        List<UserDomain> users = userDao.selectUsersExt(userParam);
        return new PageInfo<>(users);
    }
}
