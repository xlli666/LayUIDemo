package com.example.demo;

import com.example.demo.pojo.UsersDomain;
import com.example.demo.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UsersService usersService;

    @Test
    public void contextLoads() {
        Map<String,Object> map = new HashMap<>();
        map.put("start",0);
        map.put("size",8);
        List<UsersDomain> list = usersService.findAllUser(1,1).getList();
        System.out.println("size:"+list.size());
        System.out.println("-----测试完毕-------");
    }

}
