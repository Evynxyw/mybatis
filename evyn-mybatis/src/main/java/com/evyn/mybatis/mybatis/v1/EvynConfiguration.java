package com.evyn.mybatis.mybatis.v1;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName EvynConfiguration
 * @Description:
 * @Author xyw
 * @Date 2018/11/24 9:14
 * @Version 1.0
 */
public class EvynConfiguration {
    /**
     * @Author xyw
     * @MethodName getMapper
     * @Description: 通过动态代理类来获取
     * @Date 2018/11/24 9:32
     * @Param [clazz]
     * @return T
     **/
    public <T> T getMapper(Class<T> clazz, EvynSqlSession sqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},
                new EvynMapperProxy(sqlSession));
    }

    static class TestMapperXml{
        public static final String namespace = "com.evyn.mybatis.mybatis.v1.TestMapper";

        public static final Map<String,String> methodSql = new HashMap<>();

        static{
            methodSql.put("selectByPrimaryKey", "select * from test where id = %d");
        }
    }
}
