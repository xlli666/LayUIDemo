package com.example.demo.controller.back;

import com.example.demo.pojo.EmployeeDomain;
import com.example.demo.pojo.RequestEmpParam;
import com.example.demo.service.EmployeeService;
import com.example.demo.util.LayUITable;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("/query")
    @ResponseBody
    public Object findAllEmp1(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "1") int pageSize,
                              RequestEmpParam eParam) {
        System.out.println("编号: " + eParam.geteId() + ", 电话: " + eParam.geteTel());
        return employeeService.findAllEmp(pageNum, pageSize);
    }

    @RequestMapping("/query22")
    @ResponseBody
    public Object findAllEmp2(@RequestParam(name = "page", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(name = "limit", required = false, defaultValue = "1") int pageSize,
                              RequestEmpParam requestEmpParam) {
        System.out.println(pageNum+"############"+pageSize);
        System.out.println("编号: " + requestEmpParam.geteId() + ", 电话: " + requestEmpParam.geteTel());

        PageInfo<EmployeeDomain> helperResult =  employeeService.findAllEmp2(pageNum, pageSize);
        return LayUITable.tableData(helperResult.getTotal(), helperResult.getList());

    }
}
