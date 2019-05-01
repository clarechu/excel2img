package cn.clare.www.excel2img.util;

import cn.clare.www.excel2img.constant.TableConstant;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * @ClassName ImageUtil
 * @Description TODO
 * @Author clare
 * @Date 2019/4/30 20:22
 * @Version 1.0
 */
public class ImageUtil {

    public static void getImage(String imageName, List<Object> objects, List<Object> objects1) {
        int TotalWidth = TableConstant.TABLE_HEIGHT * 2 + TableConstant.FIRST_WIDTH_LINE * 2;
        int TotalHeight = TableConstant.TABLE_WIDTH * objects.size() + TableConstant.FIRST_HEIGHT_LINE * 2;
        BufferedImage image = new BufferedImage(TotalWidth, TotalHeight, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = image.getGraphics();
        Graphics2D g2 = (Graphics2D) graphics;
        //给默认白底
        g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, TotalWidth, TotalHeight);
        //给第一列颜色
        g2.setColor(new Color(75, 157, 161));
        g2.fillRect(TableConstant.FIRST_WIDTH_LINE, TableConstant.FIRST_HEIGHT_LINE, TableConstant.FIRST_WIDTH_LINE + TableConstant.TABLE_HEIGHT, TableConstant.TABLE_WIDTH * objects.size());

        //给第二列颜色
        g2.setColor(new Color(233, 233, 233));
        g2.fillRect(TableConstant.FIRST_WIDTH_LINE + TableConstant.TABLE_HEIGHT, TableConstant.FIRST_HEIGHT_LINE, TableConstant.TABLE_HEIGHT, TableConstant.TABLE_WIDTH * objects.size());

        g2.setColor(Color.black);

        //设置字体属性
        FontProfile(g2);

        int high = 100;
        g2.setStroke(new BasicStroke(1.5f));
        //绘画表格线
        int h = TableConstant.FIRST_HEIGHT_LINE;

        //横线
        g2.setColor(new Color(243, 250, 255));
        for (int i = 0; i <= objects.size(); i++) {
            g2.drawLine(TableConstant.FIRST_WIDTH_LINE, h, TableConstant.TABLE_HEIGHT * TableConstant.HEIGHT_TABLE_NUMBER + TableConstant.FIRST_WIDTH_LINE, h);
            h += TableConstant.TABLE_WIDTH;
        }

        int w = TableConstant.FIRST_WIDTH_LINE;

        //设置竖线
        g2.setColor(new Color(243, 250, 255));
        for (int i = 0; i <= TableConstant.HEIGHT_TABLE_NUMBER; i++) {
            g2.drawLine(w, TableConstant.FIRST_HEIGHT_LINE, w, TableConstant.FIRST_HEIGHT_LINE + TableConstant.TABLE_WIDTH * objects.size());
            w += TableConstant.TABLE_HEIGHT;
        }


        int h1 = TableConstant.FIRST_HEIGHT_LINE;
        int w1 = TableConstant.FIRST_WIDTH_LINE;
        int height = 0;
        int width = 0;
        //填充文字
        for (int i =0;i< objects.size(); i++){
            g2.setColor(new Color(243, 250, 255));
            graphics.drawString(objects.get(i).toString(), w1 + 5, h1 + width + 30);
            g2.setColor(new Color(0, 0, 0));
            graphics.drawString(objects1.get(i).toString(), w1 + 5 + TableConstant.TABLE_HEIGHT, h1 + width + 30);
            height += TableConstant.TABLE_HEIGHT;
            width += TableConstant.TABLE_WIDTH;
        }

        String dir = System.getProperty("user.dir");
        PictureUtil.createImage(dir + "/png/" + imageName, image);
    }

    public static void FontProfile(Graphics2D g2) {
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,RenderingHints.VALUE_STROKE_DEFAULT);
        g2.setFont(new Font(TableConstant.FontName, Font.PLAIN, TableConstant.SIZE));
    }


}
