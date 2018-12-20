package com.example.demo.service;

import com.example.demo.pojo.UsersDomain;
import com.github.pagehelper.PageInfo;

public interface UsersService {
    PageInfo<UsersDomain> findAllUser(int pageNum, int pageSize);
    PageInfo<UsersDomain> findAllUser2(int pageNum, int pageSize);
}
