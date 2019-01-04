package com.example.demo.controller.back;

import com.example.demo.util.LayUISuccess;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/demo")
public class UploadController {
    @RequestMapping("/upload")
    @ResponseBody
    public Object uploadImg(MultipartFile file){
        System.out.println(file.getOriginalFilename());
        return LayUISuccess.uploadResData(file.getOriginalFilename());
    }
}
