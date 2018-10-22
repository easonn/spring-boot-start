package com.eason.demo.springbootmqredis.po;

import java.io.Serializable;

public class Demo implements Serializable {
    private Integer id;
    private String remark;
    private String realName;
    private Integer gender;

    public Demo(Integer id, String remark, String realName, Integer gender) {
        this.id = id;
        this.remark = remark;
        this.realName = realName;
        this.gender = gender;
    }

    public Demo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", remark='" + remark + '\'' +
                ", realName='" + realName + '\'' +
                ", gender=" + gender +
                '}';
    }
}
