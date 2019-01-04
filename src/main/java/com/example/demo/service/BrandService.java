package com.example.demo.service;

import com.example.demo.pojo.BrandDomain;
import com.github.pagehelper.PageInfo;
import org.springframework.transaction.annotation.Transactional;

public interface BrandService {
    PageInfo<BrandDomain> findBrand(int pageNum, int pageSize);
    void saveBrand(BrandDomain brand, Long[] categoryId);
    void removeBrand(Long brandId);
}
