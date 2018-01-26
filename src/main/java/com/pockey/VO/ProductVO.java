package com.pockey.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品（包含类目）
 * Created by LIQing
 * 2017/10/28 17:22
 */
@Data
public class ProductVO implements Serializable{

    private static final long serialVersionUID = -2530545163329850780L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
