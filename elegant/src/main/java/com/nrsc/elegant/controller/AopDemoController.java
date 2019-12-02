package com.nrsc.elegant.controller;

import com.nrsc.elegant.pojo.UserInfo;
import com.nrsc.elegant.service.AopDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 *  @author : Sun Chuan
 *  @date : 2019/12/1 21:38
 *  Description：
 */
@RestController
@RequestMapping(value = "/users")
public class AopDemoController {

    @Autowired
    private AopDemoService aopDemoService;


    @GetMapping("/list/{positionCode}")
    public List<UserInfo> getUserInfo(@PathVariable Long positionCode) {
        return aopDemoService.getUserInfoListByPositionCode(positionCode);
    }
}
