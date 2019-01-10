package com.example.demo.dao;

import com.example.demo.pojo.Specification;
import org.springframework.stereotype.Component;

@Component("specificationDao")
public interface SpecificationDao {
    Specification selectSpecification(Long cid);
    void insertSpecification(Specification specDomain);
}
