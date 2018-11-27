package com.evyn.mybatis.mybatis.v2.executor;

import com.evyn.mybatis.mybatis.v2.config.LConfiguration;
import com.evyn.mybatis.mybatis.v2.config.MapperRegistory;
import com.evyn.mybatis.mybatis.v2.statement.LStatementHandler;


/**
 * @ClassName LSimpleExecutor
 * @Description:
 * @Author xyw
 * @Date 2018/11/25 19:00
 * @Version 1.0
 */
public class LSimpleExecutor implements LExecutor {

    public LConfiguration configuration;

    public LSimpleExecutor(LConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public <T> T query(MapperRegistory.MapperData mapperData, Object parameter) throws Exception{
        LStatementHandler handler = new LStatementHandler();
        return (T) handler.query(mapperData, parameter);
    }

}
