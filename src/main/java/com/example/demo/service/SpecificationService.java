package com.example.demo.service;

import com.example.demo.pojo.SpecificationDomain;

public interface SpecificationService {
    SpecificationDomain specificationInfo(Long cid);
    void saveSpecification(SpecificationDomain specDomain);
}
