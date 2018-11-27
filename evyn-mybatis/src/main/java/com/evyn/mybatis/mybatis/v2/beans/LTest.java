package com.evyn.mybatis.mybatis.v2.beans;

import lombok.Data;

@Data
public class LTest {
    private Integer id;

    private Integer nums;

    private String name;

    public LTest(Integer id, Integer nums, String name) {
        this.id = id;
        this.nums = nums;
        this.name = name;
    }

    public LTest() {

    }
}