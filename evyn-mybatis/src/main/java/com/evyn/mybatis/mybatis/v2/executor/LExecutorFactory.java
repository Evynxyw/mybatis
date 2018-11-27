package com.evyn.mybatis.mybatis.v2.executor;

import com.evyn.mybatis.mybatis.v2.config.LConfiguration;

/**
 * @ClassName ExecutorFactory
 * @Description:
 * @Author xyw
 * @Date 2018/11/26 21:12
 * @Version 1.0
 */
public class LExecutorFactory {
    private static final String SIMPLE = "SIMPLE";
    private static final String CACHING = "CHCHING";

    public static LExecutor DEFAULT(LConfiguration configuration){
        return get(SIMPLE, configuration);
    }

    public static LExecutor get(String key, LConfiguration configuration) {
        if(SIMPLE.equalsIgnoreCase(key)){
            return new LSimpleExecutor(configuration);
        }

        if(CACHING.equalsIgnoreCase(key)){
            return new LCachingExecutor(new LSimpleExecutor(configuration));
        }

        throw new RuntimeException("no executor found");
    }

    public enum ExecutorType{
        SIMPLE,CHCHING
    }
}
