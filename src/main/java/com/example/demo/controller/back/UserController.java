package com.example.demo.controller.back;

import com.example.demo.pojo.UserDomain;
import com.example.demo.pojo.UserRequestParam;
import com.example.demo.service.UserService;
import com.example.demo.util.LayUISuccess;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/demo")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/query")
    @ResponseBody
    public Object findAllUser1(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "1") int pageSize) {
        System.out.println("---------------------------");
        return userService.findAllUser(pageNum, pageSize);
    }

    @RequestMapping("/query22")
    @ResponseBody
    public Object findAllUser2(@RequestParam(name = "page", required = false, defaultValue = "1") int pageNum,
                              @RequestParam(name = "limit", required = false, defaultValue = "1") int pageSize,
                              UserRequestParam userParam) {
        System.out.println(pageNum+"############"+pageSize);
        System.out.println("编号: " + userParam.getNumberParam() + ", 电话: " + userParam.getTelParam());

        PageInfo<UserDomain> helperResult =  userService.findUsersBy(pageNum, pageSize, userParam);
        return LayUISuccess.tableData(helperResult.getTotal(), helperResult.getList());

    }
}
