package com.evyn.mybatis.mybatis.v2;

import com.evyn.mybatis.mybatis.v2.beans.LTest;
import com.evyn.mybatis.mybatis.v2.config.LConfiguration;
import com.evyn.mybatis.mybatis.v2.config.mappers.TestMapper;
import com.evyn.mybatis.mybatis.v2.executor.LExecutorFactory;
import com.evyn.mybatis.mybatis.v2.session.LSqlSession;

/**
 * @ClassName BootStrap
 * @Description:
 * @Author xyw
 * @Date 2018/11/26 21:08
 * @Version 1.0
 */
public class BootStrap {
    public static void main(String[] args) {
        start();
    }

    public static void start(){
        LConfiguration configuration = new LConfiguration();
        configuration.setScanPath("com.evyn.mybatis.mybatis.v2.config.mappers");
        configuration.build();
        // 普通查询
        /*LSqlSession session = new LSqlSession(LExecutorFactory.get(
                LExecutorFactory.ExecutorType.SIMPLE.name(), configuration),
                configuration);*/
        // 缓存查询
        LSqlSession session = new LSqlSession(LExecutorFactory.get(
                LExecutorFactory.ExecutorType.CHCHING.name(), configuration),
                configuration);
        TestMapper testMapper = session.getMapper(TestMapper.class);
        long start = System.currentTimeMillis();
        LTest test = testMapper.selectByPrimaryKey(1);
        System.out.println(test);
        System.out.println("cost:" + (System.currentTimeMillis() - start));

        System.out.println("--------------------------------------------------------");
        long start1 = System.currentTimeMillis();
        LTest test1 = testMapper.selectByPrimaryKey(1);
        System.out.println(test1);
        System.out.println("cost:" + (System.currentTimeMillis() - start1));
    }
}
