package com.example.demo.dao;

import com.example.demo.pojo.EmployeeDomain;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("employeeDao")
public interface EmployeeDao {
    List<EmployeeDomain> selectEmployee();

    List<EmployeeDomain> selectEmployeeEx();
}
