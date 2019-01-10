package com.example.demo.service.impl;

import com.example.demo.dao.SkuDao;
import com.example.demo.dao.SpuDao;
import com.example.demo.dao.SpuDetailDao;
import com.example.demo.dao.StockDao;
import com.example.demo.pojo.*;
import com.example.demo.service.GoodsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    private final SpuDao spuDao;

    private final SpuDetailDao spuDetailDao;

    private final SkuDao skuDao;

    private final StockDao stockDao;

    @Autowired
    public GoodsServiceImpl(SpuDao spuDao, SpuDetailDao spuDetailDao, SkuDao skuDao, StockDao stockDao) {
        this.spuDao = spuDao;
        this.spuDetailDao = spuDetailDao;
        this.skuDao = skuDao;
        this.stockDao = stockDao;
    }

    @Override
    public PageInfo<Goods> querySpuByPageAndSort(int pageNum, int pageSize, Boolean saleable, String keyWord) {
        // 1、查询SPU
        // 分页
        PageHelper.startPage(pageNum,pageSize);
        List<Spu> spuList = spuDao.selectSpuBy(saleable,keyWord);
        List<Goods> goodsList = spuList.stream().map(spu -> {
            // 2、把spu变为goods
            Goods goods = new Goods();
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

    @Override
    @Transactional
    public void saveGoods(Goods goods) {
        // 保存spu
        goods.setSaleable(true);
        goods.setValid(true);
        goods.setCreateTime(new Date());
        goods.setLastUpdateTime(goods.getCreateTime());
        spuDao.insertSpu(goods);
        // 保存spu详情
        goods.getSpuDetail().setSpuId(goods.getId());
        spuDetailDao.insertSpuDetail(goods.getSpuDetail());
        // 保存sku和库存信息
        saveSkuAndStock(goods.getSkus(), goods.getId());
    }

    @Override
    public SpuDetail querySpuDetailById(Long spuId) {
        return spuDetailDao.selectSpuDetailById(spuId);
    }

    @Override
    public List<Sku> querySkuBySpuId(Long spuId) {
        // 查询sku
        Sku record = new Sku();
        record.setSpuId(spuId);
        List<Sku> skus = skuDao.selectSkuBySpuId(spuId);
        for (Sku sku : skus) {
            // 同时查询出库存
            sku.setStock(stockDao.selectStockById(sku.getId()).getStock());
        }
        return skus;
    }

    private void saveSkuAndStock(List<Sku> skus, Long spuId){
        for (Sku sku : skus) {
            if (sku.getEnable()){
                // 保存sku
                sku.setSpuId(spuId);
                sku.setCreateTime(new Date());
                sku.setLastUpdateTime(sku.getCreateTime());
                skuDao.insertSku(sku);
                // 保存库存信息
                Stock stock = new Stock();
                stock.setSkuId(sku.getId());
                stock.setStock(sku.getStock());
                stockDao.insertStock(stock);
            }
        }
    }
}
