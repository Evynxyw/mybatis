package com.evyn.mybatis.mybatis.v2.config;

import com.evyn.mybatis.mybatis.v2.beans.LTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MapperRegistory
 * @Description:
 * @Author xyw
 * @Date 2018/11/25 19:22
 * @Version 1.0
 */
public class MapperRegistory {
    public static final Map<String, MapperData> methodSqlMapping = new HashMap<>();

    public MapperRegistory() {
        methodSqlMapping.put("com.evyn.mybatis.mybatis.v2.config.mappers.TestMapper.selectByPrimaryKey",
                new MapperData("select * from test where id = %d", LTest.class));
    }

    public class MapperData<T>{
        public String sql;
        public Class<T> classType;

        public MapperData(String sql, Class<T> classType) {
            this.sql = sql;
            this.classType = classType;
        }

        public String getSql() {
            return sql;
        }

        public void setSql(String sql) {
            this.sql = sql;
        }

        public Class<T> getClassType() {
            return classType;
        }

        public void setClassType(Class<T> classType) {
            this.classType = classType;
        }
    }

    public MapperData get(String nameSpace){
        return methodSqlMapping.get(nameSpace);
    }
}
