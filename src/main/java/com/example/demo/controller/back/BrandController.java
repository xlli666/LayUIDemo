package com.example.demo.controller.back;

import com.example.demo.pojo.Brand;
import com.example.demo.service.BrandService;
import com.example.demo.util.LayUISuccess;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/item/brand")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    /**
     * 品牌分页查询(后续应该增加查询条件)
     *
     * @param pageNum  页码
     * @param pageSize 每页数量
     * @return 返回前端表格数据LayUISuccess.tableData
     */
    @RequestMapping("/query")
    @ResponseBody
    public Object findBrand(@RequestParam(name = "page", required = false, defaultValue = "1") int pageNum,
                            @RequestParam(name = "limit", required = false, defaultValue = "1") int pageSize) {
        System.out.println("**********query*********");
        PageInfo<Brand> helperBrand = brandService.findBrand(pageNum, pageSize);
        return LayUISuccess.tableData(helperBrand.getTotal(), helperBrand.getList());
    }

    /**
     * 上传LOGO图片
     *
     * @param file 文件
     * @return 上传结果LayUISuccess.uploadResData
     */
    @RequestMapping("/upload")
    @ResponseBody
    public Object uploadLogo(MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        return LayUISuccess.uploadResData(file.getOriginalFilename());
    }

    /**
     * 添加品牌信息
     *
     * @param category 分类
     * @param brand    品牌数据(name, letter, image)
     * @return 添加结果LayUISuccess.formSubResData
     */
    @RequestMapping("/add")
    @ResponseBody
    public Object addBrand(@RequestParam(value = "category[]") Long[] category,
                           Brand brand) {
        System.out.println("***********add***********");
        brandService.saveBrand(brand, category);
        return LayUISuccess.formSubResData("OK");
    }

    /**
     * 删除品牌信息
     *
     * @param brand 品牌数据(id, name, letter, image)
     * @return 删除结果LayUISuccess.formSubResData
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object deleteBrand(Brand brand) {
        System.out.println("**********delete**********");
        brandService.removeBrand(brand.getId());
        return LayUISuccess.formSubResData("OK");
    }
}
