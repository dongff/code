package cn.com.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: dongff
 * @description:
 * @date: Created in 2022-08-05 13:51
 * @modified By:
 */
@Data
@TableName("product_info")
public class ProductInfo {

    private Integer id;
    // 商品名称
    // @NotNull(message = "商品名称不允许为空")
    private String productName;
    // 商品价格
    // @Min(value = 0, message = "商品价格不允许为负数")
    private BigDecimal productPrice;
    // 上架状态
    private Integer productStatus;
}
