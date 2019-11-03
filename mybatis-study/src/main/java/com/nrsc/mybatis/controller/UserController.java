package com.nrsc.mybatis.controller;

import com.nrsc.mybatis.po.UserPo;
import com.nrsc.mybatis.pojo.TUser;
import com.nrsc.mybatis.repository.TUserMapper;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Arrays;
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
    public List<TUser> selectByRole(@PathVariable Integer role) {
        return userMapper.selectByRole(role);
    }

    /***
     * 测试<foreach></foreach>标签
     * @param ids
     * @return
     */
    @PostMapping("/findAllUserByIdIn")
    public List<TUser> findAllUserByIdIn(@RequestBody List<Long> ids) {
        return userMapper.findAllUserByIdIn(ids);
    }

    /***
     * 测试使用<foreach></foreach>标签进行批量更新
     * @return
     */
    @GetMapping("batchSaveTUser1")
    public int batchSaveTUser() {
        TUser user1 = new TUser();
        user1.setUsername("king");
        user1.setPassword("123456");
        user1.setGender("F");
        user1.setSalary(new BigDecimal(1800));

        TUser user2 = new TUser();
        user2.setUsername("james");
        user2.setPassword("1234567890");
        user2.setGender("M");
        user2.setSalary(new BigDecimal(1800));

        int i = userMapper.batchSaveTUser(Arrays.asList(user1, user2));
        System.out.println("------获取批量更新后数据的主键--------");
        System.err.println(user1.getId());
        System.err.println(user2.getId());
        return i;

    }


    /***
     *大数据量插入主要耗时在session的频繁开启，
     * 因此可以先关闭session的自动提交----》"攒"一些命令然后关闭session的方式进行数据的批量插入或更新等操作
     * @return
     */

    /***
     * （1）注入SqlSessionTemplate
     */
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @GetMapping("batchSaveTUser2")
    public void batchSaveTUser2() {
        //（2）关闭session的自动提交
        SqlSession sqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
        //（3）获取到mapper对象
        TUserMapper mapper = sqlSession.getMapper(TUserMapper.class);

        //(4)进行数据插入或更新等操作
        TUser user1 = new TUser();
        user1.setUsername("king11");
        user1.setPassword("1234567");
        user1.setGender("F");
        user1.setSalary(new BigDecimal(1800));
        //插入1
        int insert = mapper.insert(user1);

        TUser user2 = new TUser();
        user2.setUsername("james11");
        user2.setPassword("123456789011");
        user2.setGender("M");
        user2.setSalary(new BigDecimal(1800));

        //插入2
        int insert1 = mapper.insert(user2);

        //提交session
        sqlSession.commit();
        //关闭session连接
        sqlSession.close();
        System.out.println("------获取批量更新后数据的主键--------");
        System.err.println(user1.getId());
        System.err.println(user2.getId());
    }


}
