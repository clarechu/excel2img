package cn.vpclub.heshenghuo.video.controller;

import cn.vpclub.heshenghuo.video.model.response.BaseResponse;
import cn.vpclub.heshenghuo.video.service.ExcelFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "excel")
@Slf4j
public class ExcelFileController {
    @Autowired
    private ExcelFileService excelFileService;

    @RequestMapping(method = RequestMethod.POST, value = "")
    public BaseResponse get(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        BaseResponse baseResponse = excelFileService.get(fileName, file);
        return baseResponse;
    }
}
