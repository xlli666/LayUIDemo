package com.example.demo.dao;

import com.example.demo.pojo.UserDomain;
import com.example.demo.pojo.UserRequestParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("usersDao")
public interface UserDao {
    List<UserDomain> selectUsers();

    List<UserDomain> selectUsersExt(UserRequestParam userParam);
}
