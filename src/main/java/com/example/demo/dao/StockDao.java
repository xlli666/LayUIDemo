package com.example.demo.dao;

import com.example.demo.pojo.Stock;
import org.springframework.stereotype.Component;

@Component("stockDao")
public interface StockDao {
    void insertStock(Stock stock);
    Stock selectStockById(Long skuId);
}
