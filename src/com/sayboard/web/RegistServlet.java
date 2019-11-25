package com.sayboard.web;

import com.sayboard.domain.User;
import com.sayboard.exception.MsgException;
import com.sayboard.service.UserService;
import com.sayboard.utils.JDBCUtil;
import com.sayboard.utils.WebUtil;

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
 * @date 2019-11-19
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String empName = request.getParameter("empName");
        String password = request.getParameter("password");

        if (WebUtil.isNull(empName)){
            request.setAttribute("msg","用户名不能为空！");
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }
        if (WebUtil.isNull(password)){
            request.setAttribute("msg","密码不能为空！");
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }

        /*Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn =  JDBCUtil.getConnection();
            ps = conn.prepareStatement("select * from user where empName = ?");
            ps.setString(1,empName);
            rs = ps.executeQuery();
            if(rs.next()){
                request.setAttribute("msg","用户名已存在");
                request.getRequestDispatcher("/regist.jsp").forward(request,response);
                return;
            }else{
                ps = conn.prepareStatement("insert into user values(null,?,?)");

                ps.setString(1,empName);
                ps.setString(2,password);
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }*/

        UserService userService = new UserService();
        User user = new User(0, empName, password);
        try {
            userService.registUser(user);
        }catch (MsgException e){
            request.setAttribute("msg",e.getMessage());
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }



        response.getWriter().write("<h1 align='center'>" + "<font color='red'>恭喜,注册成功! 3秒之后跳转到登入页..</font>" + "</h1>");
        response.setHeader("refresh","3;url=http://www.sayboard.com");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
