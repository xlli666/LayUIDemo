package com.example.demo.dao;

import com.example.demo.pojo.SpuDetail;
import org.springframework.stereotype.Component;

@Component("spuDetailDao")
public interface SpuDetailDao {
    void insertSpuDetail(SpuDetail spuDetail);
    SpuDetail selectSpuDetailById(Long spuId);
}
