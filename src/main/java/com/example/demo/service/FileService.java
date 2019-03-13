package com.example.demo.service;

import com.example.demo.util.ThreadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Service
public class FileService {

    @Value("${demo.thymeleaf.destinationPath}")
    private String destPath;

    private final TemplateEngine templateEngine;

    @Autowired
    public FileService(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    /**
     * 创建html页面
     * @param id
     * @throws Exception
     */
    public void createHtml(Long id) throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("aa","123");

        Context context = new Context();// 创建上下文
        context.setVariables(map);// 把数据加入上下文
        File temp = new File(id+".html");// 创建输出流，关联到一个临时文件
        File dest = createPath(id);// 目标页面文件
        File back = new File(id+"_back.html");// 备份原页面文件
        try (PrintWriter writer = new PrintWriter(temp,"UTF-8")){
            templateEngine.process("item", context, writer);// 利用thymeleaf模板引擎生成 静态页面
            if (dest.exists()) {
                dest.renameTo(back);// 如果目标文件已经存在，先备份
            }
            FileCopyUtils.copy(temp, dest);// 将新页面覆盖旧页面
            back.delete();// 成功后将备份页面删除
        } catch (IOException e) {
            back.renameTo(dest);// 失败后，将备份页面恢复
            throw new Exception(e);// 重新抛出异常，声明页面生成失败
        } finally {
            if (temp.exists()) {
                temp.delete();// 删除临时页面
            }
        }
    }

    private File createPath(Long id) {
        if (id == null) {
            return null;
        }
        File dest = new File(destPath);
        if (!dest.exists()) {
            dest.mkdirs();
        }
        return new File(dest, id + ".html");
    }

    /**
     * 异步创建html页面
     * @param id
     */
    public void syncCreateHtml(Long id){
        ThreadUtils.execute(()->{
            try {
                createHtml(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
