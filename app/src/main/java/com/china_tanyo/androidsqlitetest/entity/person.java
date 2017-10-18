package com.china_tanyo.androidsqlitetest.entity;

/**
 * Created by gushi on 2017/10/18.
 */

public class person {

    private int id;
    private String name;
    private int sex;
    private int age;

    public person() {
    }

    public person(int id, String name, int sex, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
}
