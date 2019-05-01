package cn.clare.www.excel2img.service;

import cn.clare.www.excel2img.util.ImageUtil;
import cn.clare.www.excel2img.util.ImportExcelUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName ExcelService
 * @Description TODO
 * @Author clare
 * @Date 2019/5/2 00:06
 * @Version 1.0
 */
@Service
public class ExcelService {

    public void get(String fileName) {
        try {
            File file = new File(fileName);
            List<List<Object>> dataList = ImportExcelUtil.importExcel(file);
            for (int i = 1; i < dataList.size(); i++) {
                String name = (String) dataList.get(i).get(0) + i + ".jpg";
                dataList.get(0).remove(0);
                dataList.get(i).remove(0);
                ImageUtil.getImage(name, dataList.get(0), dataList.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
