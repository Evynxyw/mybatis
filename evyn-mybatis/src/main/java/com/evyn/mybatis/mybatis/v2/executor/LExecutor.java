package com.evyn.mybatis.mybatis.v2.executor;

import com.evyn.mybatis.mybatis.v2.config.MapperRegistory;

/**
 * @ClassName LExecutor
 * @Description:
 * @Author xyw
 * @Date 2018/11/24 23:14
 * @Version 1.0
 */
public interface LExecutor {

    <T> T query(MapperRegistory.MapperData mapperData, Object parameter) throws Exception;
}
