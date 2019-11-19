package com.sayboard.servlet;

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
@WebServlet("/registServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        /*String username = request.getParameter("username");
        String password = request.getParameter("password");
*/
        response.getWriter().write("<h1 align='center'>" + "<font color='red'>恭喜注册成功! 3秒之后跳转到登入页..</font>" + "</h1>");
        response.setHeader("refresh","3;url=http://www.sayboard.com");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
