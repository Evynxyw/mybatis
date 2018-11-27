package com.evyn.mybatis.mybatis.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName EvynMapperProxy
 * @Description:
 * @Author xyw
 * @Date 2018/11/24 9:26
 * @Version 1.0
 */
public class EvynMapperProxy implements InvocationHandler {

    private EvynSqlSession sqlSession;

    public EvynMapperProxy(EvynSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getDeclaringClass().getName().equals(EvynConfiguration.TestMapperXml.namespace)){
            String sql = EvynConfiguration.TestMapperXml.methodSql.get(method.getName());
            return sqlSession.selectOne(sql, String.valueOf(args[0]));
        }
        return method.invoke(args);
    }


}
