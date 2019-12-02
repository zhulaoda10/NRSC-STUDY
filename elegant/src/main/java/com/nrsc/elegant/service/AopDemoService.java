package com.nrsc.elegant.service;

import com.nrsc.elegant.pojo.UserInfo;

import java.util.List;

/***
 *  @author : Sun Chuan
 *  @date : 2019/12/1 21:38
 *  Description：
 */
public interface AopDemoService {
    /***
     * 根据职务code查询用户
     * @param positionCode
     * @return
     */
    List<UserInfo> getUserInfoListByPositionCode(Long positionCode);
}
