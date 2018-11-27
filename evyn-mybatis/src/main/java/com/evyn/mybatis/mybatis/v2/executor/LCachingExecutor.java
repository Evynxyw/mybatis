package com.evyn.mybatis.mybatis.v2.executor;

import com.evyn.mybatis.mybatis.v2.config.LConfiguration;
import com.evyn.mybatis.mybatis.v2.config.MapperRegistory;
import com.evyn.mybatis.mybatis.v2.statement.LStatementHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LCachingExecutor
 * @Description:
 * @Author xyw
 * @Date 2018/11/26 21:21
 * @Version 1.0
 */
public class LCachingExecutor implements LExecutor{
    private LConfiguration configuration;
    private LSimpleExecutor delegate;

    private Map<String, Object> localCache = new HashMap<>();

    public LCachingExecutor(LSimpleExecutor delegate) {
        this.delegate = delegate;
    }

    public LCachingExecutor(LConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T query(MapperRegistory.MapperData mapperData, Object parameter) throws Exception {
        Object result = localCache.get(mapperData.getSql());
        if(null != result){
            System.out.println("命中缓存");
            return (T) result;
        }

        result = delegate.query(mapperData, parameter);
        return (T) result;
    }
}
