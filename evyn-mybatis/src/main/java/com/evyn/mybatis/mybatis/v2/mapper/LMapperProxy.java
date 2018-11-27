package com.evyn.mybatis.mybatis.v2.mapper;

import com.evyn.mybatis.mybatis.v2.config.MapperRegistory;
import com.evyn.mybatis.mybatis.v2.session.LSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName LMapperProxy
 * @Description:
 * @Author xyw
 * @Date 2018/11/26 20:43
 * @Version 1.0
 */
public class LMapperProxy<T> implements InvocationHandler {

    public final LSqlSession sqlSession;
    public final Class<T> mapperInterface;

    public LMapperProxy(LSqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperRegistory.MapperData mapperData = sqlSession.getConfiguration()
                .getMapperRegistory().get(method.getDeclaringClass().getName() + "." + method.getName());
        if(null != mapperData){
            System.out.println(String.format("SQL [ %s ], parameter [ %s ]",mapperData.getSql(), args[0]));
            return sqlSession.selectOne(mapperData, String.valueOf(args[0]));
        }
        return method.invoke(proxy,args);
    }
}
