package com.example.demo.dao;

import com.example.demo.pojo.UsersDomain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("employeeDao")
public interface UsersDao {
    List<UsersDomain> selectUsers();

    List<UsersDomain> selectUsersExt();
}
