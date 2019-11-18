package com.nrsc.elegant.handle;


import com.nrsc.elegant.enums.ResultEnum;
import com.nrsc.elegant.exception.ElegantCheckedException;
import com.nrsc.elegant.exception.ElegantRuntimeException;
import com.nrsc.elegant.util.ResultVOUtil;
import com.nrsc.elegant.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

/***
 * @author : Sun Chuan
 * @date : 2019/10/18 22:26
 * Description：全局统一异常处理类
 *
 *
 *          该类的处理逻辑:
 *              （1）对请求参数异常和我们自定义的异常分别做单独处理
 *              （2）对可能出现的未知异常进行单独处理
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandle {

    /***
     * 可能出现的未知异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultVO handle(Exception e) {
        log.error("【系统异常】{}", e);
        return ResultVOUtil.error(ResultEnum.FAILURE);
    }

    /***
     * 参数异常 -- ConstraintViolationException()
     * 用于处理类似http://localhost:8080/user/getUser?age=30&name=yoyo请求中age和name的校验引发的异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = {ConstraintViolationException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultVO urlParametersExceptionHandle(ConstraintViolationException e) {
        log.error("【请求参数异常】:{}", e);
        //收集所有错误信息
        List<String> errorMsg = e.getConstraintViolations()
                .stream().map(s -> s.getMessage()).collect(Collectors.toList());
        return ResultVOUtil.error(ResultEnum.PARAM_ERROR.getCode(), errorMsg.toString());
    }

    /***
     * 参数异常 --- MethodArgumentNotValidException和BindException
     * MethodArgumentNotValidException --- 用于处理请求参数为实体类时校验引发的异常 --- Content-Type为application/json
     * BindException --- 用于处理请求参数为实体类时校验引发的异常  --- Content-Type为application/x-www-form-urlencoded
     * @param e
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultVO bodyExceptionHandle(Exception e) {
        log.error("【请求参数异常】:{}", e);
        BindingResult bindingResult = null;
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            bindingResult = ex.getBindingResult();
        } else {
            BindException ex = (BindException) e;
            ex.getBindingResult();
        }
        if (bindingResult != null) {
            //收集所有错误信息
            List<String> errorMsg = bindingResult.getFieldErrors().stream()
                    .map(s -> s.getDefaultMessage()).collect(Collectors.toList());
            return ResultVOUtil.error(ResultEnum.PARAM_ERROR.getCode(), errorMsg.toString());
        }

        return ResultVOUtil.error(ResultEnum.PARAM_ERROR);
    }

    /***
     * 自定义异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.IM_USED)
    @ExceptionHandler(value = {ElegantRuntimeException.class, ElegantCheckedException.class})
    @ResponseBody
    public ResultVO elegantExceptionHandle(ElegantRuntimeException e) {
        log.error("发生自定义异常", e);
        if (e.getComplexMsg() != null) {
            return ResultVOUtil.error(e.getCode(), e.getComplexMsg());
        }
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }


}

