package com.evyn.mybatis.mybatis.v1;

/**
 * @ClassName Entry
 * @Description:
 * @Author xyw
 * @Date 2018/11/24 11:11
 * @Version 1.0
 */
public class Entry {
    public static void main(String[] args) {
        EvynSqlSession sqlSession = new EvynSqlSession(new EvynConfiguration(),
                new EvynSimpleExecutor());
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        Test test = testMapper.selectByPrimaryKey(1);
        System.out.println(test);
    }
}
