package com.example.demo.service.impl;

import com.example.demo.dao.SpuDao;
import com.example.demo.pojo.GoodsDomain;
import com.example.demo.pojo.SpuDomain;
import com.example.demo.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    private final SpuDao spuDao;

    @Autowired
    public GoodsServiceImpl(SpuDao spuDao) {
        this.spuDao = spuDao;
    }

    @Override
    public PageInfo<GoodsDomain> querySpuByPageAndSort(int pageNum, int pageSize, Boolean saleable, String keyWord) {
        // 1、查询SPU
        // 分页
        PageHelper.startPage(pageNum,pageSize);
        List<SpuDomain> spuList = spuDao.selectSpuBy(saleable,keyWord);
        List<GoodsDomain> goodsList = spuList.stream().map(spu -> {
            // 2、把spu变为goods
            GoodsDomain goods = new GoodsDomain();
            // 属性拷贝
            BeanUtils.copyProperties(spu, goods);
            // 3、查询spu的商品分类名称
            // 暂略
            goods.setCname("分类名称测试");
            // 4、查询spu的品牌名称
            // 暂略
            goods.setBname("品牌名称测试");
            return goods;
        }).collect(Collectors.toList());
        return new PageInfo<>(goodsList);
    }
}
