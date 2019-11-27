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
        String textfield = request.getParameter("textfield");
        System.out.println(empName);


        UserService userService = new UserService();
        if (empName != null){
            if (userService.checkisnullUser(empName)){
                response.getWriter().write("<font color='red'>用户名已存在！</font>");
            }else {
                response.getWriter().write("<font color='green'>用户名可以使用！</font>");
            }
        }else {
            if (userService.checkisnullUser(textfield)){
                response.getWriter().write("<font color='green'>接收人已注册</font>");
            }else {
                response.getWriter().write("<font color='red'>接收人未注册</font>");
            }
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
