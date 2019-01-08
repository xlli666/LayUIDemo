package com.example.demo.dao;

import com.example.demo.pojo.SpuDomain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("spuDao")
public interface SpuDao {
    List<SpuDomain> selectSpuBy(@Param("saleable") Boolean saleable, @Param("keyWord") String keyWord);
}
