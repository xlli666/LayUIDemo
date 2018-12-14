package com.example.demo.service;

import com.example.demo.pojo.EmployeeDomain;
import com.github.pagehelper.PageInfo;

public interface EmployeeService {
    PageInfo<EmployeeDomain> findAllEmp(int pageNum, int pageSize);
    PageInfo<EmployeeDomain> findAllEmp2(int pageNum, int pageSize);
}
