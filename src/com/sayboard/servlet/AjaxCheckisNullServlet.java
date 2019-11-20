package com.sayboard.servlet;

import com.sayboard.utils.JBDCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @outhor moke
 * @date 2019-11-20
 */
@WebServlet("/AjaxCheckisNullServlet")
public class AjaxCheckisNullServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String username = request.getParameter("empName");
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JBDCUtil.getConnection();
            ps = conn.prepareStatement("select * from user where empName = ?");
            ps.setString(1,username);
            rs = ps.executeQuery();
            if (rs.next()){
                response.getWriter().write("<font color='red'>用户名已存在！</font>");
            }else {
                response.getWriter().write("<font color='green'>用户名可以使用！</font>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }finally {
            JBDCUtil.close(conn,ps,rs);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
