package com.evyn.mybatis.mybatis.v2.statement;

import com.evyn.mybatis.mybatis.v2.config.LConfiguration;
import com.evyn.mybatis.mybatis.v2.config.MapperRegistory;
import com.evyn.mybatis.mybatis.v2.result.ResultSetHandler;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

/**
 * @ClassName LStatementHandler
 * @Description:
 * @Author xyw
 * @Date 2018/11/25 19:04
 * @Version 1.0
 */
public class LStatementHandler {
    public LConfiguration configuration;
    public ResultSetHandler resultSetHandler;

    public LStatementHandler(LConfiguration configuration) {
        this.configuration = configuration;
    }

    public LStatementHandler() {
        this.resultSetHandler = new ResultSetHandler();
    }

    public <T> T query(MapperRegistory.MapperData mapperData, Object parameter)
            throws Exception{
        Connection conn = getConn();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(String.format(mapperData.getSql(),
                    Integer.parseInt(String.valueOf(parameter))));
            preparedStatement.execute();

            return resultSetHandler.handler(preparedStatement.getResultSet(),
                    mapperData.getClassType());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection getConn(){
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://192.168.0.110:3306/gp?useUnicode=true&" +
                "characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true&" +
                "useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = "root";
        String password = "root123456";
        Connection conn = null;
        try {
            Class.forName(driver); //classLoader,加载对应驱动
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
