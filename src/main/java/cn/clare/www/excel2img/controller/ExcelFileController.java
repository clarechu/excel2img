package cn.clare.www.excel2img.controller;

import cn.clare.www.excel2img.service.ExcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "excel")
@Slf4j
public class ExcelFileController {
    @Autowired
    private ExcelService excelService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public String get(String name) {
        excelService.get(name);
        return "success";
    }
}
