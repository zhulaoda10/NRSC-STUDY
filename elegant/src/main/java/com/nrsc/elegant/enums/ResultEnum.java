package com.nrsc.elegant.enums;

import lombok.Getter;

/**
 * @author : Sun Chuan
 * @date : 2019/10/18 22:24
 * Description：封装返回状态码和提示信息的枚举类
 */
@Getter
public enum ResultEnum {
    SUCCESS(0, "成功"),

    FAILURE(-1, "系统异常"),

    COMPLEX_FAILURE(-2, ""),


    PARAM_ERROR(300, "参数不正确"),

    RESULT_NOT_EXIST(301, "查询结果不存在");


    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
