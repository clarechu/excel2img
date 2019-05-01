package cn.clare.www.excel2img.util;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

public class ImportExcelUtil {

    public static List<List<Object>> importExcel(File file) throws IOException {
        String fileName = file.getName();
        String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);
        if ("xlsx".equals(extension)) {
            List<List<Object>> data = ImportExcelUtil.read2007Excel(new FileInputStream(file));
            return data;
        } else {
            throw new IOException("不支持的文件类型");
        }
    }

    /**
     * 读取Office 2007 excel
     */
    public static List<List<Object>> read2007Excel(InputStream file) throws IOException {
        List<List<Object>> list = new LinkedList<List<Object>>();
        // 构造 XSSFWorkbook 对象，strPath 传入文件路径
        XSSFWorkbook xwb = new XSSFWorkbook(file);
        // 读取第一章表格内容
        XSSFSheet sheet = xwb.getSheetAt(0);
        Object value = null;
        XSSFRow row = null;
        XSSFCell cell = null;
        int rows = sheet.getPhysicalNumberOfRows();
        rows = 2;
        for (int i = sheet.getFirstRowNum(); i <= rows; i++) {
            row = sheet.getRow(i);
            if (row == null) {
                continue;
            }
            List<Object> linked = new LinkedList<Object>();
            for (int j = row.getFirstCellNum(); j <= row.getLastCellNum(); j++) {
                cell = row.getCell(j);
                if (cell == null) {
                    continue;
                }
                DecimalFormat df = new DecimalFormat("0");// 格式化 number String 字符
                //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 格式化日期字符串
                DecimalFormat nf = new DecimalFormat("0");// 格式化数字
                switch (cell.getCellType()) {
                    case XSSFCell.CELL_TYPE_STRING:
                        //   System.out.println(i+"行"+j+" 列 is String type");
                        value = cell.getStringCellValue();
                        break;
                    case XSSFCell.CELL_TYPE_NUMERIC:
                        //   System.out.println(i+"行"+j+" 列 is Number type ; DateFormt:"+cell.getCellStyle().getDataFormatString());
                        if ("@".equals(cell.getCellStyle().getDataFormatString())) {
                            value = df.format(cell.getNumericCellValue());
                        } else if ("General".equals(cell.getCellStyle().getDataFormatString())) {
                            value = nf.format(cell.getNumericCellValue());
                        } else {
                            // value = sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
                            value = nf.format(cell.getNumericCellValue());
                        }
                        break;
                    case XSSFCell.CELL_TYPE_BOOLEAN:
                        //   System.out.println(i+"行"+j+" 列 is Boolean type");
                        value = cell.getBooleanCellValue();
                        break;
                    case XSSFCell.CELL_TYPE_BLANK:
                        value = "";
                        break;
                    default:
                        //   System.out.println(i+"行"+j+" 列 is default type");
                        value = cell.toString();
                }
                if (value == null || "".equals(value)) {
                    continue;
                }
                linked.add(value);
            }
            list.add(linked);
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/clare/Desktop/四厂/压力表选型工具（天川）.xlsx");
        List<List<Object>> dataList = importExcel(file);
        for (int i = 1; i < dataList.size(); i++) {
            String name = (String) dataList.get(i).get(0) + i + ".jpg";
            dataList.get(0).remove(0);
            dataList.get(i).remove(0);
            ImageUtil.getImage(name, dataList.get(0), dataList.get(i));
        }
    }

}
