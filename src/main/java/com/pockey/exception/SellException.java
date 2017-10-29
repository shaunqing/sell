package com.pockey.exception;

import com.pockey.enums.ResultEnum;

/**
 * Created by LIQing
 * 2017/10/29 16:52
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
