package cn.clare.www.excel2img.bean;

import cn.clare.www.excel2img.dto.PolicyPersonDto;
import cn.clare.www.excel2img.dto.PolicyProductDto;
import lombok.Data;

/**
 * @ClassName PolicyBean
 * @Description TODO
 * @Author clare
 * @Date 2019/4/30 20:07
 * @Version 1.0
 */
@Data
public class PolicyBean {

    private PolicyPersonDto policyPersonDto;

    private PolicyProductDto policyProductDto;

}
