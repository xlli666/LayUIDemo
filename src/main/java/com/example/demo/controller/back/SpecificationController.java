package com.example.demo.controller.back;

import com.example.demo.pojo.SpecificationDomain;
import com.example.demo.service.SpecificationService;
import com.example.demo.util.LayUISuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item/specifications/")
public class SpecificationController {

    private final SpecificationService specificationService;

    @Autowired
    public SpecificationController(SpecificationService specificationService) {
        this.specificationService = specificationService;
    }

    @RequestMapping("query")
    @ResponseBody
    public Object specQuery(Long category){
        return specificationService.specificationInfo(category);
    }

    @RequestMapping("add")
    @ResponseBody
    public Object specAdd(SpecificationDomain specDomain){
        specificationService.saveSpecification(specDomain);
        return LayUISuccess.formSubResData("OK");
    }
}
