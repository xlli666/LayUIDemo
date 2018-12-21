package com.example.demo.service;

import com.example.demo.pojo.UserDomain;
import com.example.demo.pojo.UserRequestParam;
import com.github.pagehelper.PageInfo;

public interface UserService {
    PageInfo<UserDomain> findAllUser(int pageNum, int pageSize);
    PageInfo<UserDomain> findUsersBy(int pageNum, int pageSize, UserRequestParam userParam);
}
