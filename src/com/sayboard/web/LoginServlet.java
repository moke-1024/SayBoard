package com.sayboard.web;

import com.sayboard.domain.Mage;
import com.sayboard.domain.User;
import com.sayboard.exception.MsgException;
import com.sayboard.service.MageService;
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
import java.util.ArrayList;

/**
 * @outhor moke
 * @date 2019-11-20
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String empName = request.getParameter("empName");
        String password = request.getParameter("password");

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
        MageService mageService = new MageService();
        ArrayList<Mage> mages = mageService.xianshiMag();;
        HttpSession session1 = request.getSession();
        session1.setAttribute("mages",mages);

        response.sendRedirect(request.getContextPath()+"/main.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
