package com.example.demo.service;

import com.example.demo.pojo.Goods;
import com.example.demo.pojo.Sku;
import com.example.demo.pojo.SpuDetail;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface GoodsService {
    PageInfo<Goods> querySpuByPageAndSort(int pageNum, int pageSize, Boolean saleable, String keyWord);
    void saveGoods(Goods goods);
    SpuDetail querySpuDetailById(Long spuId);
    List<Sku> querySkuBySpuId(Long spuId);
}
