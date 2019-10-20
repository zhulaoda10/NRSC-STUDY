package com.nrsc.elegant.exception;


import com.nrsc.elegant.enums.ResultEnum;
import lombok.Getter;

/**
 * @author : Sun Chuan
 * @date : 2019/10/18 22:21
 * Description：自定义异常
 */
@Getter
public class ElegantException extends RuntimeException {

    private Integer code;

    public ElegantException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public ElegantException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
