package com.example.demo.controller.back;

import com.example.demo.pojo.UsersDomain;
import com.example.demo.pojo.UsersRequestParam;
import com.example.demo.service.UsersService;
import com.example.demo.util.LayUITable;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping("/query")
    @ResponseBody
    public Object findAllUser1(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "1") int pageSize,
                              UsersRequestParam usersParam) {
        System.out.println("编号: " + usersParam.geteId() + ", 电话: " + usersParam.geteTel());
        return usersService.findAllUser(pageNum, pageSize);
    }

    @RequestMapping("/query22")
    @ResponseBody
    public Object findAllUser2(@RequestParam(name = "page", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(name = "limit", required = false, defaultValue = "1") int pageSize,
                              UsersRequestParam usersRequestParam) {
        System.out.println(pageNum+"############"+pageSize);
        System.out.println("编号: " + usersRequestParam.geteId() + ", 电话: " + usersRequestParam.geteTel());

        PageInfo<UsersDomain> helperResult =  usersService.findAllUser2(pageNum, pageSize);
        return LayUITable.tableData(helperResult.getTotal(), helperResult.getList());

    }
}
