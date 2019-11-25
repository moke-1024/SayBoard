package com.sayboard.dao;

import com.sayboard.domain.User;
import com.sayboard.utils.JDBCUtil;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @outhor moke
 * @date 2019-11-25
 */
public class UserDao {
    public User findUserByempNameAndPassword(String empName, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select * from user where empName = ? and password = ?");
            ps.setString(1,empName);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if (rs.next()){
                User user = new User();
                user.setEmpName(rs.getString("empName"));
                user.setPassword(rs.getString("password"));
                return user;
            }else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
    }

    public boolean findUserByUsername(String empName) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn =  JDBCUtil.getConnection();
            ps = conn.prepareStatement("select * from user where empName = ?");
            ps.setString(1,empName);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }else{
               return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }
    }

    public void addUser(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn =  JDBCUtil.getConnection();
            ps = conn.prepareStatement("insert into user values(null,?,?)");
            ps.setString(1,user.getEmpName());
            ps.setString(2,user.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.close(conn,ps,null);
        }
    }
}
