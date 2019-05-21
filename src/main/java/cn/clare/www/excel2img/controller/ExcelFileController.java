package cn.clare.www.excel2img.controller;

import cn.clare.www.excel2img.service.ExcelService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(value = "excel")
@Slf4j
public class ExcelFileController {
    @Autowired
    private ExcelService excelService;

    @Value("${application.data.path}")
    private String path;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public String get(String name, String fileName) {
        excelService.get(path, fileName, name);
        return "success";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/v")
    public String post1(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        return "success";
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public String post(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (file.isEmpty()) {
            return "Please select a file to upload";
        }
        String filename = file.getOriginalFilename();// 获取文件名
        String realPath = path + filename;
        File file1 = new File(path);
        if (!file1.exists() && !file1.isDirectory()) {
            System.out.println(path+"目录不存在，需要创建");
            //创建目录
            file1.mkdir();
        }
        try {
            File file2 = new File(realPath);
            // FileUtils.copyInputStreamToFile()这个方法里对IO进行了自动操作，不需要额外的再去关闭IO流
            FileUtils.copyInputStreamToFile(file.getInputStream(), file2);// 复制临时文件到指定目录下
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
        excelService.get(path, filename.split("\\.")[0], realPath);
        return "success";
    }

}
