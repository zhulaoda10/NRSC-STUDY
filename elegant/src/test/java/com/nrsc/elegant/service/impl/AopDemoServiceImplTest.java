package com.nrsc.elegant.service.impl;

import com.nrsc.elegant.pojo.UserInfo;
import com.nrsc.elegant.service.AopDemoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/***
 *  @author : Sun Chuan
 *  @date : 2019/12/1 23:04
 *  Description：
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class AopDemoServiceImplTest {

    @Autowired
    private AopDemoService aopDemoService;

    @Test
    void getUserInfoListByPositionCode() {

        List<UserInfo> res = aopDemoService.getUserInfoListByPositionCode(111L);
        log.info("==结果为：【{}】==", res);
        List<UserInfo> errorRes = aopDemoService.getUserInfoListByPositionCode(0L);
        log.info("==结果为：【{}】==", errorRes);
    }
}