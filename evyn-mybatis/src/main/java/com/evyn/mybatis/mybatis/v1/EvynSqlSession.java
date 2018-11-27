package com.evyn.mybatis.mybatis.v1;


/**
 * @ClassName SqlSession
 * @Description:
 * @Author xyw
 * @Date 2018/11/24 9:12
 * @Version 1.0
 */
public class EvynSqlSession {
    EvynConfiguration configuration;
    EvynExecutor executor;

    public EvynSqlSession(EvynConfiguration configuration, EvynExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<T> clazz){
        return configuration.getMapper(clazz,this);
    }

    /**
     * @Author xyw
     * @MethodName selectOne
     * @Description: 
     * @Date 2018/11/24 9:24
     * @Param [statement, parameter]
     * @return T
     **/
    public <T> T selectOne(String statement, String parameter){
        return executor.query(statement, parameter);
    }

}
