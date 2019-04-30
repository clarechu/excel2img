package cn.clare.www.excel2img.dto;

import lombok.Data;

/**
 * @ClassName PolicyProductDto
 * @Description TODO
 * @Author clare
 * @Date 2019/4/30 20:08
 * @Version 1.0
 */
@Data
public class PolicyProductDto {

    private String brand;
    private String model;
    private String productId;
    private String purchaseDate;
    private String purchasePrice;
    private String purchaseWay;
    private String warrantyPhone;
}
