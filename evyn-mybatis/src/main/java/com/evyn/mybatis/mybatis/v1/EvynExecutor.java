package com.evyn.mybatis.mybatis.v1;

/**
 * @ClassName EvynExecutor
 * @Description:
 * @Author xyw
 * @Date 2018/11/24 9:13
 * @Version 1.0
 */
public interface EvynExecutor {
    <T> T query(String statement, String parameter);
}
