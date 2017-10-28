package com.pockey.VO;

import lombok.Data;

/**
 * http请求返回最外层对象
 * Created by LIQing
 * 2017/10/28 17:17
 */
@Data
public class ResultVO<T> {

    private Integer code; // 错误码

    private String msg; // 提示信息

    private T data; // 具体内容


}
