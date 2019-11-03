package com.nrsc.mybatis.controller;

import com.nrsc.mybatis.po.UserPo;
import com.nrsc.mybatis.pojo.TUser;
import com.nrsc.mybatis.repository.TUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Sun Chuan
 * @date : 2019/11/2 10:41
 * Description：
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private TUserMapper userMapper;

    /****
     * 测试<trim></trim>标签
     * @param user
     * @return
     */
    @PutMapping("/create")
    public Integer create(@RequestBody TUser user) {
        int insert = userMapper.insertSelective(user);
        return insert;
    }

    /***
     * 测试<where></where>标签
     * @param userPo
     * @return
     */
    @PostMapping("/get")
    public List<TUser> findTUserSelective(@RequestBody UserPo userPo) {
        List<TUser> tUser = userMapper.findTUserSelective(userPo);
        return tUser;
    }

    /***
     * 测试<set></set>标签
     * @param tUser
     * @return
     */
    @PostMapping("/update")
    public Integer update(@RequestBody TUser tUser) {
        int i = userMapper.updateByPrimaryKeySelective(tUser);
        return i;
    }

    /***
     * 测试choose、when和otherwise标签
     * @param role
     * @return
     */
    @GetMapping("/get/{role}")
    public List<TUser> selectByRole(@PathVariable Integer role){

        return  userMapper.selectByRole(role);
    }

}
