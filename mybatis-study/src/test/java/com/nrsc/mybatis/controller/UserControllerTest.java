package com.nrsc.mybatis.controller;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

/**
 * @author : Sun Chuan
 * @date : 2019/11/3 19:57
 * Description：
 */
class UserControllerTest {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/nrsc-mybatis?characterEncoding=utf-8&serverTimezone=GMT&useSSL=false";

    // Database credentials
    static final String USER = "root";
    static final String PASS = "123456";

    @Test
    public void updateDemo() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 2: 注册mysql的驱动
            Class.forName(JDBC_DRIVER);

            // STEP 3: 获得一个连接
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 4: 关闭自动提交
            conn.setAutoCommit(false);
            stmt = conn.createStatement();

            // STEP 5: 创建一个更新
            System.out.println("Creating statement...");
            String sql1 = "update t_user  set username= '帅帅' where id= '1' ";
            String sql2 = "insert into t_user ( username) values ('deer')";
            stmt.addBatch(sql1);
            stmt.addBatch(sql2);
            System.out.println(stmt.toString());//打印sql
            int[] executeBatch = stmt.executeBatch();
            System.out.println("此次修改影响数据库的行数为：" + Arrays.toString(executeBatch));

            // STEP 6: 手动提交数据 ---> 真正开始对数据库发出指令
            conn.commit();

            // STEP 7: 关闭连接
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            try {
                conn.rollback();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            se.printStackTrace();
        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}