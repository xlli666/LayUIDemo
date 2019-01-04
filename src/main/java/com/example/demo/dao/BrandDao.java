package com.example.demo.dao;

import com.example.demo.pojo.BrandDomain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("brandDao")
public interface BrandDao {
    List<BrandDomain> selectBrand();
    int insertBrand(BrandDomain brand);
    int insertCategoryBrand(@Param("categoryId") Long categoryId, @Param("brandId")Long brandId);
    void deleteBrand(Long brandId);
    void deleteCategoryBrand(Long brandId);
}
