package cn.clare.www.excel2img.util;

import cn.clare.www.excel2img.constant.TableConstant;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName ImageUtil
 * @Description TODO
 * @Author clare
 * @Date 2019/4/30 20:22
 * @Version 1.0
 */
public class ImageUtil {

    public static void getImage(List<Object> objects, List<Object> objects1) {
        BufferedImage image = new BufferedImage(TableConstant.IMAGE_WIDTH, TableConstant.IMAGE_HEIGHT,
                BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setColor(new Color(152, 255, 166));
        g2.fillRect(0, 0, TableConstant.IMAGE_WIDTH/2, TableConstant.IMAGE_HEIGHT);
        g2.setColor(new Color(255, 208, 235));
        g2.fillRect(TableConstant.IMAGE_WIDTH/2, 0, TableConstant.IMAGE_WIDTH, TableConstant.IMAGE_HEIGHT);
        g2.setColor(Color.black);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_DEFAULT);
        g2.setFont(new Font("宋体", Font.PLAIN, 12));
        int high = 100;
        g2.setStroke(new BasicStroke(TableConstant.STROKE));
        //绘画表格线
        int h = TableConstant.FIRST_HEIGHT_LINE;
        //横线
        for (int i = 0; i <= TableConstant.WIDTH_TABLE_NUMBER; i++) {
            g2.drawLine(TableConstant.FIRST_WIDTH_LINE, h, TableConstant.TABLE_HEIGHT * TableConstant.HEIGHT_TABLE_NUMBER + TableConstant.FIRST_WIDTH_LINE, h);
            h += TableConstant.TABLE_WIDTH;
        }

        int w = TableConstant.FIRST_WIDTH_LINE;
        //设置竖线
        for (int i = 0; i <= TableConstant.HEIGHT_TABLE_NUMBER; i++) {
            g2.drawLine(w, TableConstant.FIRST_HEIGHT_LINE, w, TableConstant.FIRST_HEIGHT_LINE + TableConstant.TABLE_WIDTH * TableConstant.WIDTH_TABLE_NUMBER);
            w += TableConstant.TABLE_HEIGHT;
        }


        int h1 = TableConstant.FIRST_HEIGHT_LINE;
        int w1 = TableConstant.FIRST_WIDTH_LINE;
        int height = 0;
        int width = 0;
        //填充文字
        for (int i =0;i< objects.size(); i++){
            graphics.drawString(objects.get(i).toString(), w1 + 5, h1 + width + 35);
            graphics.drawString(objects1.get(i).toString(), w1 + 5 + TableConstant.TABLE_HEIGHT, h1 + width + 35);
            height += TableConstant.TABLE_HEIGHT;
            width += TableConstant.TABLE_WIDTH;
        }

        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        PictureUtil.createImage(dir + "/png/test.png", image);
    }

}
