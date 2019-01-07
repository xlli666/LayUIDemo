package com.example.demo.service.impl;

import com.example.demo.dao.SpecificationDao;
import com.example.demo.pojo.SpecificationDomain;
import com.example.demo.service.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("specificationService")
public class SpecificationServiceImpl implements SpecificationService {

    private final SpecificationDao specificationDao;

    @Autowired
    public SpecificationServiceImpl(SpecificationDao specificationDao) {
        this.specificationDao = specificationDao;
    }

    @Override
    public SpecificationDomain specificationInfo(Long cid) {
        return specificationDao.selectSpecification(cid);
    }

    @Override
    public void saveSpecification(SpecificationDomain specDomain) {
        specificationDao.insertSpecification(specDomain);
    }
}
