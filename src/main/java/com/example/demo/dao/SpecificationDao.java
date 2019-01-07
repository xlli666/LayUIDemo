package com.example.demo.dao;

import com.example.demo.pojo.SpecificationDomain;
import org.springframework.stereotype.Component;

@Component("specificationDao")
public interface SpecificationDao {
    SpecificationDomain selectSpecification(Long cid);
    void insertSpecification(SpecificationDomain specDomain);
}
