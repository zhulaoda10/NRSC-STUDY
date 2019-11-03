package com.nrsc.mybatis.repository;


import com.nrsc.mybatis.pojo.TCompany;

public interface TCompanyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TCompany record);

    int insertSelective(TCompany record);

    TCompany selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TCompany record);

    int updateByPrimaryKey(TCompany record);
}