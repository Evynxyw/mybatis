package com.evyn.mybatis.mybatis.v2.session;

import com.evyn.mybatis.mybatis.v2.config.LConfiguration;
import com.evyn.mybatis.mybatis.v2.config.MapperRegistory;
import com.evyn.mybatis.mybatis.v2.executor.LExecutor;
import com.evyn.mybatis.mybatis.v2.mapper.LMapperProxy;

import java.lang.reflect.Proxy;


/**
 * @ClassName LSqlSession
 * @Description:
 * @Author xyw
 * @Date 2018/11/24 23:08
 * @Version 1.0
 */
public class LSqlSession {
    private LExecutor executor;
    private LConfiguration configuration;

    public LConfiguration getConfiguration() {
        return configuration;
    }

    public LSqlSession(LExecutor executor, LConfiguration configuration) {
        this.executor = executor;
        this.configuration = configuration;
    }

    public <T> T getMapper(Class<T> clazz){
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz}, new LMapperProxy(this, clazz));
    }


    public <T> T selectOne(MapperRegistory.MapperData mapperData, Object parameter)
            throws Exception {
        return executor.query(mapperData, parameter);
    }
}
