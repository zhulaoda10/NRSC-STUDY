package com.nrsc.mybatis.pojo;

import java.util.Date;

/**
 * @author : Sun Chuan
 * @date : 2019/11/1 1:16
 * Description：注意： 如果你的数据库里所有表都有id、createTime和updateTime可以将其提到一个基类里如BaseEntity
 * 但是为了不让其他类生成该字段，你必须在BaseEntity里生成这三个字段的get/set方法
 * 同时在mbg.xml里配置
 */
public class BaseEntity {
    /*** id*/
    private Long id;
    /*** 创建时间*/
    private Date createTime;
    /*** 更新时间*/
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
