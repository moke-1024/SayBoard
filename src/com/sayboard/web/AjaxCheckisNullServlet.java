package com.sayboard.web;

import com.sayboard.domain.User;
import com.sayboard.exception.MsgException;
import com.sayboard.service.UserService;
import com.sayboard.utils.JDBCUtil;

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
        String empName = request.getParameter("empName");
        String password = request.getParameter("password");

        UserService userService = new UserService();
        User user = new User(0, empName, password);
        if (userService.checkisnullUser(user)){
            response.getWriter().write("<font color='red'>用户名已存在！</font>");
        }else {
            response.getWriter().write("<font color='green'>用户名可以使用！</font>");
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
