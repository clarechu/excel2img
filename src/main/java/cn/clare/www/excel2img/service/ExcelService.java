package cn.clare.www.excel2img.service;

import cn.clare.www.excel2img.util.ImageUtil;
import cn.clare.www.excel2img.util.ImportExcelUtil;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Formatter;
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

    public void get(String path, String fileName, String filePath) {
        long time = System.currentTimeMillis();
        try {
            File file = new File(filePath);
            List<List<Object>> dataList = ImportExcelUtil.importExcel(file);
            List<Object> heard = dataList.get(0);
            heard.remove(0);
            for (int i = 1; i < dataList.size(); i++) {
                System.out.println(" WRITE NUMBER:"+ i);
                String name = (String) dataList.get(i).get(0) + i + ".jpg";
                dataList.get(i).remove(0);
                ImageUtil.getImage(path, fileName, name, heard, dataList.get(i));
            }
            long time1 = System.currentTimeMillis();
            System.out.println(" ------------------------------------------------------------------------");
            System.out.println(" BUILD SUCCESS");
            System.out.println(" ------------------------------------------------------------------------");
            System.out.println(" Total time:  " + ((time1 - time) / 1000) + "s");
            System.out.println(" Finished at:" + time1);
            System.out.println(" ------------------------------------------------------------------------");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
