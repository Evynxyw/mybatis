package com.evyn.mybatis.mybatis.v2.result;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ClassName ResultSetHandler
 * @Description:
 * @Author xyw
 * @Date 2018/11/25 19:51
 * @Version 1.0
 */
public class ResultSetHandler {

    public <T> T handler(ResultSet rs, Class classType) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Object resultObj = new DefaultObjectFactory().create(classType);
        if(rs.next()){
            int i = 0;
            for(Field field : resultObj.getClass().getDeclaredFields()){
                setValue(resultObj, rs, field, i);
            }
        }

        return (T) resultObj;
    }

    public void setValue(Object resultObj, ResultSet rs, Field field, int i)
            throws NoSuchMethodException, SQLException, InvocationTargetException,
            IllegalAccessException {
        Method setMethod = resultObj.getClass().getMethod("set" + upperCapital(field.getName()),
        field.getType());
        setMethod.invoke(resultObj,getResult(field,rs));
    }

    public Object getResult(Field field, ResultSet rs) throws SQLException {
        Class<?> type = field.getType();
        if(Integer.class == type){
            return rs.getInt(field.getName());
        }

        if(String.class == type){
            return rs.getString(field.getName());
        }

        return rs.getString(field.getName());
    }

    public String upperCapital(String name){
        String fist = name.substring(0, 1);
        String tail = name.substring(1);
        return fist.toUpperCase() + tail;
    }
}
