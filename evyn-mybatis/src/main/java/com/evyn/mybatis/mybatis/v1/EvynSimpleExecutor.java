package com.evyn.mybatis.mybatis.v1;

import java.sql.*;

/**
 * @ClassName EvynSimpleExecutor
 * @Description:
 * @Author xyw
 * @Date 2018/11/24 10:43
 * @Version 1.0
 */
public class EvynSimpleExecutor implements  EvynExecutor {
    @Override
    public <T> T query(String statement, String parameter) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Test test = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://192.168.0.110:3306/gp?" +
                    "useUnicode=true&characterEncoding=utf-8&useSSL=false&useJDBCCompliantTimezoneShift=true" +
                    "&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root", "root123456");
            String sql = String.format(statement,Integer.parseInt(parameter));
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                test = new Test();
                test.setId(rs.getInt(1));
                test.setNums(rs.getInt(2));
                test.setName(rs.getString(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != connection) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return (T)test;
    }
}
