package com.pockey.form;

import lombok.Data;

/**
 * Created by LIQing
 * 2017/12/2 11:27
 */
@Data
public class CategoryForm {
    private Integer categoryId;

    /**
     * 类目名字.
     */
    private String categoryName;

    /**
     * 类目编号.
     */
    private Integer categoryType;
}
