package com.nrsc.mybatis.repository;


import com.nrsc.mybatis.po.UserPo;
import com.nrsc.mybatis.pojo.TUser;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface TUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    List<TUser> findTUserSelective(UserPo userPo);

    List<TUser> selectByRole(Integer role);

    /***
     * 不加@Param注解会报错
     * @param ids
     * @return
     */
    List<TUser> findAllUserByIdIn(@Param("ids") Collection<Long> ids);

    /***
     * 不用加@Param注解
     * @param TUsers
     * @return
     */
    int batchSaveTUser(Collection<TUser> TUsers);

    /***
     * 使用Map时不要加@Param注解 ---> 加了会报错
     * @param params
     * @return
     */
    List<TUser> selectByUsernameAndGender(Map<String, Object> params);


    /***
     * 使用Map一种比较画蛇添足的方式
     * @param params
     * @return
     */
    List<TUser> selectByUsernameAndGenderMap2(@Param("params") Map<String, Object> params);


    /***
     * 多个参数时，最好加上@Param注解 ---因为在动态sql的情况下不加@Param注解会报错
     * @param username
     * @param gender
     * @return
     */
    List<TUser> selectByUsernameAndGenderParam(@Param("username") String username, @Param("gender") String gender);

    /***
     * 不加@Param注解也可以 --- 但我一般都会用上面的方式
     * @param username
     * @param gender
     * @return
     */
    List<TUser> selectByUsernameAndGenderParam2(String username, String gender);

    /***
     * 使用pojo做参数 --- 不加@Param
     * @param user
     * @return
     */
    List<TUser> selectByUsernameAndGenderPojo(UserPo user);

    /***
     * 使用po类做参数 --- @Param （画蛇添个足）
     * @param user
     * @return
     */
    List<TUser> selectByUsernameAndGenderPojo2(@Param("user") UserPo user);


    List<TUser> findByUsername(String  username);
}