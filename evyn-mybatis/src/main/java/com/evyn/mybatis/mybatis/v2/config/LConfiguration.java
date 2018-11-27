package com.evyn.mybatis.mybatis.v2.config;

import lombok.Data;

/**
 * @ClassName LConfiguration
 * @Description:
 * @Author xyw
 * @Date 2018/11/24 23:15
 * @Version 1.0
 */
@Data
public class LConfiguration {
    private String scanPath;
    private MapperRegistory mapperRegistory = new MapperRegistory();

    public LConfiguration scanPath(String scanPath){
        this.scanPath = scanPath;
        return this;
    }

    public void build(){
        if(null == scanPath && scanPath.length() < 1){
            throw new RuntimeException("scanPath is required .");
        }
    }

    public static void main(String[] args) {
        new LConfiguration().scanPath("com.evyn.mybatis.mybatis.v2.config.mappers").build();
    }
}
