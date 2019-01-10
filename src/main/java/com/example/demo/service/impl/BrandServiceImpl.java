package com.example.demo.service.impl;

import com.example.demo.dao.BrandDao;
import com.example.demo.pojo.Brand;
import com.example.demo.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("brandService")
public class BrandServiceImpl implements BrandService {

    private final BrandDao brandDao;

    @Autowired
    public BrandServiceImpl(BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    @Override
    public PageInfo<Brand> findBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Brand> brandList = brandDao.selectBrand();
        return new PageInfo<>(brandList);
    }

    @Override
    @Transactional
    public void saveBrand(Brand brand, Long[] categoryId) {
        brandDao.insertBrand(brand);
        for (Long cid:categoryId) {
            brandDao.insertCategoryBrand(cid, brand.getId());
        }
    }

    @Override
    @Transactional
    public void removeBrand(Long brandId) {
        brandDao.deleteBrand(brandId);
        brandDao.deleteCategoryBrand(brandId);
    }

}
