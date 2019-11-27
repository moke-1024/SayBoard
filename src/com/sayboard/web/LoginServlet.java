package com.sayboard.web;

import com.sayboard.domain.Mage;
import com.sayboard.domain.User;
import com.sayboard.exception.MsgException;
import com.sayboard.service.MageService;
import com.sayboard.service.UserService;
import com.sayboard.utils.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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
            User user = userService.loginUser(empName, MD5Util.md5(password));
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
        }catch (MsgException e){
            request.setAttribute("msg",e.getMessage());
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return;
        }


        HttpSession session = request.getSession();
        MageService mageService = new MageService();
        List<Mage> mages = mageService.xianshiByNameMag(empName);
        session.setAttribute("mages",mages);

        response.sendRedirect(request.getContextPath()+"/main.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
