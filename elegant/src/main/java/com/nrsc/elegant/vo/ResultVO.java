package com.nrsc.elegant.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : Sun Chuan
 * @date : 2019/10/18 22:13
 * Description：http请求返回的最外层对象
 */
@Data
public class ResultVO<T>  implements Serializable {
    private static final long serialVersionUID = 3009132526980391812L;
    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体的内容. */
    private T data;
}
