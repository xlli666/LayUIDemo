package com.example.demo.service.impl;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.pojo.EmployeeDomain;
import com.example.demo.service.EmployeeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public PageInfo<EmployeeDomain> findAllEmp(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<EmployeeDomain> employeeDomains = employeeDao.selectEmployee();
        return new PageInfo<>(employeeDomains);
    }

    @Override
    public PageInfo<EmployeeDomain> findAllEmp2(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<EmployeeDomain> employeeDomains = employeeDao.selectEmployeeEx();
        return new PageInfo<>(employeeDomains);
    }
}
