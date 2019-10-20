package com.nrsc.elegant.controller;

import com.nrsc.elegant.enums.ResultEnum;
import com.nrsc.elegant.exception.ElegantException;
import com.nrsc.elegant.pojo.UserInfo;
import com.nrsc.elegant.util.ResultVOUtil;
import com.nrsc.elegant.vo.ResultVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author : Sun Chuan
 * @date : 2019/10/20 9:46
 * Description：
 */
@RestController
@RequestMapping("/user")
@Validated //校验URL中的请求参数时，该注解需要放在这里
public class UserInfoController {

    /***
     * ConstraintViolationException异常统一处理测试
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/getUser")
    public ResultVO<UserInfo> getUser(@NotNull(message = "name不能为空") String name,
                                      @Min(value = 18, message = "未满18岁")
                                      @NotNull(message = "age不能为空") Integer age) {
        UserInfo userInfo = new UserInfo();
        userInfo.setAge(age);
        userInfo.setName(name);
        return ResultVOUtil.success(userInfo);
    }

    /***
     * MethodArgumentNotValidException异常统一处理测试
     * Content-Type为application/json  ---> 实体类前必须要加一个@RequestBody注解才能获得到前端传来的参数
     * @param userInfo
     * @return
     */
    @PostMapping("/saveUser")
    public ResultVO<UserInfo> saveUser(@RequestBody @Validated UserInfo userInfo) {
        userInfo.setId(111L);
        return ResultVOUtil.success(userInfo);
    }

    /***
     * BindException异常统一处理测试
     * Content-Type为application/x-www-form-urlencoded ---> 即表单请求，此时不能用@RequestBody注解
     * @param userInfo
     * @return
     */
    @PostMapping("/saveUserInfo")
    public ResultVO<UserInfo> saveUserInfo(@RequestBody @Validated UserInfo userInfo) {
        userInfo.setId(111L);
        return ResultVOUtil.success(userInfo);
    }

    /***
     * ElegantException --- 自定义异常、未知异常和URL---统一处理测试
     * @param id
     * @return
     */
    @GetMapping("/getUserById/{id}")
    public ResultVO<UserInfo> getUser(@PathVariable @Max(value = 100, message = "id应小于100") Long id) {
        UserInfo userInfo = new UserInfo();
        //自定义异常
        if (id < 0) {
            throw new ElegantException(ResultEnum.PARAM_ERROR);
        }
        //未知异常
        else if (id == 0) {
            throw new RuntimeException("xxoo");
        }
        userInfo.setId(id);
        userInfo.setAge(18);
        userInfo.setName("yoyo");
        return ResultVOUtil.success(userInfo);
    }
}
