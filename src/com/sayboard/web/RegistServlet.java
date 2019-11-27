package com.sayboard.web;

import com.sayboard.domain.User;
import com.sayboard.exception.MsgException;
import com.sayboard.service.UserService;
import com.sayboard.utils.MD5Util;
import com.sayboard.utils.WebUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @outhor moke
 * @date 2019-11-19
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

        UserService userService = new UserService();
        User user = new User(0, empName, MD5Util.md5(password));
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
