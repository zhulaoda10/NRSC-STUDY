package com.nrsc.mybatis.repository;

import com.nrsc.mybatis.pojo.TUser;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Sun Chuan
 * @date : 2019/11/4 23:21
 * Description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class TUserMapperTest {
    @Autowired
    private TUserMapper userMapper;

    @Test
    public void findAllUserByIdIn() {
        List<TUser> allUserByIdIn = userMapper.findAllUserByIdIn(Arrays.asList(1L, 2L, 3L));
        System.err.println(allUserByIdIn.size());
    }

    @Test
    public void batchSaveTUser() {
        TUser tUser = new TUser();
        tUser.setSalary(new BigDecimal(11111));
        tUser.setUsername("haha");
        tUser.setPassword("heihei");

        TUser tUser1 = new TUser();
        tUser1.setSalary(new BigDecimal(2222));
        tUser1.setUsername("haha222");
        tUser1.setPassword("heihei222");
        int i = userMapper.batchSaveTUser(Arrays.asList(tUser, tUser1));
        System.err.println(i);
    }


    @Test
    public void findByUsername(){
        List<TUser> yoyo = userMapper.findByUsername("james");
        System.err.println(yoyo);
    }


}