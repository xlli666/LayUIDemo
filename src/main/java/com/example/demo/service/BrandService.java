package com.example.demo.service;

import com.example.demo.pojo.Brand;
import com.github.pagehelper.PageInfo;

public interface BrandService {
    PageInfo<Brand> findBrand(int pageNum, int pageSize);
    void saveBrand(Brand brand, Long[] categoryId);
    void removeBrand(Long brandId);
}
