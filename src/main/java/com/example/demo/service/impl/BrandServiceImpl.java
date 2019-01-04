package com.example.demo.service.impl;

import com.example.demo.dao.BrandDao;
import com.example.demo.pojo.BrandDomain;
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
    public PageInfo<BrandDomain> findBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<BrandDomain> brand = brandDao.selectBrand();
        return new PageInfo<>(brand);
    }

    @Override
    @Transactional
    public void saveBrand(BrandDomain brand, Long[] categoryId) {
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
