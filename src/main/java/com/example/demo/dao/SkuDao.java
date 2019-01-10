package com.example.demo.dao;

import com.example.demo.pojo.Sku;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("skuDao")
public interface SkuDao {
    void insertSku(Sku sku);
    List<Sku> selectSkuBySpuId(Long spuId);
}
