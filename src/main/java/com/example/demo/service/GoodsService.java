package com.example.demo.service;

import com.example.demo.pojo.GoodsDomain;
import com.github.pagehelper.PageInfo;

public interface GoodsService {
    PageInfo<GoodsDomain> querySpuByPageAndSort(int pageNum, int pageSize, Boolean saleable, String keyWord);
}
