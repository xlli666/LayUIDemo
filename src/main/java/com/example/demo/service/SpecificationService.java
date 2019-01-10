package com.example.demo.service;

import com.example.demo.pojo.Specification;

public interface SpecificationService {
    Specification specificationInfo(Long cid);
    void saveSpecification(Specification specDomain);
}
