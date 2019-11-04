package com.nrsc.mybatis.controller;

import com.nrsc.mybatis.po.UserPo;
import com.nrsc.mybatis.pojo.TUser;
import com.nrsc.mybatis.repository.TUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Sun Chuan
 * @date : 2019/11/4 20:16
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest2 {


    @Autowired
    private TUserMapper userMapper;

    // 多参数查询
    @Test
    public void testManyParamQuery() {

        String gender = "F";
        String username = "张伟";

        // 第一种方式使用map
        Map<String, Object> params = new HashMap<>();
        params.put("gender", gender);
        params.put("username", username);
        List<TUser> list1 = userMapper.selectByUsernameAndGender(params);
        System.err.println(list1.size());

        //使用map的第二种方式 --- 画蛇添足法
        List<TUser> tUsers = userMapper.selectByUsernameAndGenderMap2(params);
        System.err.println(tUsers.size());

        // 直接使用参数 ---> mapper类加@Param注解
        List<TUser> list2 = userMapper.selectByUsernameAndGenderParam(username, gender);
        System.err.println(list2.size());
        // 直接使用参数 ---> mapper类不加@Param注解
        List<TUser> list3 = userMapper.selectByUsernameAndGenderParam2(username, gender);
        System.err.println(list3.size());


        // 第三种方式用对象
        UserPo user = new UserPo();
        user.setUsername(username);
        user.setSalary(new BigDecimal(5800));
        List<TUser> list4 = userMapper.selectByUsernameAndGenderPojo(user);
        System.out.println(list4.size());
        List<TUser> tUsers1 = userMapper.selectByUsernameAndGenderPojo2(user);
        System.err.println(tUsers1.size());
    }


}
