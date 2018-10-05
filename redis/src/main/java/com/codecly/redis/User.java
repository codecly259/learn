package com.codecly.redis;

import lombok.Data;

/**
 * @ClassName User
 * @Description 用户信息
 * @Author maxinchun
 * @Date 2018/10/6 01:34
 */
@Data
public class User {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 性别   0: 女，1: 男
     */
    private int sex;

    /**
     * 身高 cm
     */
    private int height;

    /**
     * 体重  kg
     */
    private int weight;

    /**
     * 联系电话
     */
    private String telephone;

    /**
     * 地址
     */
    private String address;

    /**
     * 就职公司
     */
    private String company;


}
