package com.example.demo.controller.back;

import com.example.demo.pojo.Goods;
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

    /**
     * 根据关键词查询SPU分页数据
     * @param pageNum 起始页
     * @param pageSize 每页数据
     * @param saleable 是否上架
     * @param keyWord 关键词(title)
     * @return SPU分页数据
     */
    @RequestMapping("/spu/page")
    @ResponseBody
    public Object queryGoods(@RequestParam(name = "page", defaultValue = "1") int pageNum,
                             @RequestParam(name = "limit", defaultValue = "1") int pageSize,
                             @RequestParam(name = "saleable", required = false) Boolean saleable,
                             @RequestParam(name = "key", required = false) String keyWord){
        System.out.println("##########query##########");
        System.out.println("key: " + keyWord +", saleable: " + saleable +", pageNum: " + pageNum +", pageSize: " + pageSize);
        PageInfo<Goods> helperGoods = goodsService.querySpuByPageAndSort(pageNum, pageSize, saleable, keyWord);
        return LayUISuccess.tableData(helperGoods.getTotal(), helperGoods.getList());
    }

    // 以下方法暂未验证
    /**
     * 添加商品
     * @param goods 商品数据(品牌、分类、详细、SKU列表等)
     * @return 添加结果
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object saveGoods(Goods goods){
        System.out.println("##########add##########");
        //goodsService.saveGoods(goods);
        return LayUISuccess.formSubResData("OK");
    }

    /**
     * 根据SPU_ID查询SPU明细
     * @param spuId 主键SPU_ID
     * @return SPU明细数据
     */
    @RequestMapping("/spu/detail")
    @ResponseBody
    public Object querySpuDetailById(Long spuId){
        System.out.println("##########query spuDetail##########");
        return goodsService.querySpuDetailById(spuId);
    }

    /**
     * 根据SPU_ID查询SKU列表数据
     * @param spuId 查询条件SPU_ID
     * @return SKU列表数据
     */
    @RequestMapping("/sku/list")
    @ResponseBody
    public Object querySkuBySpuId(Long spuId){
        System.out.println("##########query skuList##########");
        return goodsService.querySkuBySpuId(spuId);
    }
}
