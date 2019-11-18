package com.nrsc.elegant.exception;


import com.nrsc.elegant.enums.ResultEnum;
import com.nrsc.elegant.util.FormatStringUtils;
import lombok.Getter;

import java.text.MessageFormat;

/***
 * @author : Sun Chuan
 * @date : 2019/10/18 22:21
 * Description：自定义异常
 *                  --- 该异常如果在代码语句里抛出,方法上也必须抛出异常
 *                  --- 当然也可以直接try..catch掉
 *
 *                  ---在实际开发中可以发现这种自定义异常几乎也是必不可少的
 */
@Getter
public class ElegantCheckedException extends Exception {

    private Integer code;

    private String complexMsg;


    public ElegantCheckedException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public ElegantCheckedException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public ElegantCheckedException(Integer code, String message, Object... arguments) {
        super("自定义异常---之复杂异常");
        String formatMsg = FormatStringUtils.formatMessage(message, '{', '}');
        this.complexMsg = MessageFormat.format(formatMsg, arguments);
        this.code = code;
    }
}
