package com.nrsc.elegant.exception;


import com.nrsc.elegant.enums.ResultEnum;
import com.nrsc.elegant.util.FormatStringUtils;
import lombok.Getter;

import java.text.MessageFormat;

/**
 * @author : Sun Chuan
 * @date : 2019/10/18 22:21
 * Description：自定义异常  --- RuntimeException可以只抛出,不用在方法上进行throw
 */
@Getter
public class ElegantRuntimeException extends RuntimeException {

    private Integer code;

    private String complexMsg;


    public ElegantRuntimeException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public ElegantRuntimeException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    /***
     * 含有占位符的异常
     * @param code
     * @param message
     * @param arguments
     */
    public ElegantRuntimeException(Integer code, String message, Object... arguments) {
        super("自定义异常---之复杂异常");
        String formatMsg = FormatStringUtils.formatMessage(message, '{', '}');
        //利用arguments替换占位符
        this.complexMsg = MessageFormat.format(formatMsg, arguments);
        this.code = code;
    }


    public static void main(String[] args) {
        String url02 = "我叫{0},今年{1}岁。";
        String name = "小明";
        String age = "28";
        url02 = MessageFormat.format(url02, name, age);
        System.out.println(url02);

        String aaa = "我是{},你是{}";
        String s = FormatStringUtils.formatMessage(aaa, '{', '}');
        System.err.println(s);
    }
}
