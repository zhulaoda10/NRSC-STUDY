package com.nrsc.mybatis.repository;


import com.nrsc.mybatis.po.UserPo;
import com.nrsc.mybatis.pojo.TUser;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface TUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    List<TUser> findTUserSelective(UserPo userPo);

    List<TUser> selectByRole(Integer role);

    List<TUser> findAllUserByIdIn(@Param("ids") Collection<Long> ids);

    int batchSaveTUser(Collection<TUser> TUsers);
}