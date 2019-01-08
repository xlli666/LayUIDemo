package com.example.demo.controller.back;

import com.example.demo.pojo.GoodsDomain;
import com.example.demo.service.GoodsService;
import com.example.demo.util.LayUISuccess;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item/goods")
public class GoodsController {

    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping("/spu/page")
    @ResponseBody
    public Object queryGoods(@RequestParam(name = "page", defaultValue = "1") int pageNum,
                             @RequestParam(name = "limit", defaultValue = "1") int pageSize,
                             @RequestParam(name = "saleable", required = false) Boolean saleable,
                             @RequestParam(name = "key", required = false) String keyWord){
        System.out.println("##########query##########");
        System.out.println("key: " + keyWord +", saleable: " + saleable +", pageNum: " + pageNum +", pageSize: " + pageSize);
        PageInfo<GoodsDomain> helperGoods = goodsService.querySpuByPageAndSort(pageNum, pageSize, saleable, keyWord);
        return LayUISuccess.tableData(helperGoods.getTotal(), helperGoods.getList());
    }
}
