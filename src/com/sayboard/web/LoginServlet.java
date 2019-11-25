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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @outhor moke
 * @date 2019-11-20
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String empName = request.getParameter("empName");
        String password = request.getParameter("password");

       /* Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs =null;
        try {
            conn = JDBCUtil.getConnection();
            ps = conn.prepareStatement("select * from user where empName = ? and password = ?");
            ps.setString(1,empName);
            ps.setString(2,password);
            rs = ps.executeQuery();
            if (rs.next()){
                HttpSession session = request.getSession();
                session.setAttribute("empName",empName);
            }else {
                request.setAttribute("msg","用户名或密码错误！");
                request.getRequestDispatcher("login.jsp").forward(request,response);
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps,rs);
        }*/
        UserService userService = new UserService();
        try {
            User user = userService.loginUser(empName,password);
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
        }catch (MsgException e){
            request.setAttribute("msg",e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }

        response.sendRedirect(request.getContextPath()+"/main.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
