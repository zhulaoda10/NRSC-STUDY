package com.nrsc.mybatis.po;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author : Sun Chuan
 * @date : 2019/11/3 15:34
 * Description：
 */
@Data
public class UserPo {

    private String username;
    private BigDecimal salary;
}
