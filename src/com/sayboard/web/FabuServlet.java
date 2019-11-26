package com.sayboard.web;

import com.sayboard.domain.Mage;
import com.sayboard.domain.User;
import com.sayboard.service.MageService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/FabuServlet")
public class FabuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String sendname =user.getEmpName();
        System.out.println(sendname);

        Date date = new Date() ;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(date);

        String acceptname = request.getParameter("textfield");
        String say = request.getParameter("textfield2");


        MageService mageService = new MageService();
        Mage mage = new Mage(0,sendname,time,acceptname,say);
        session.setAttribute("mage",mage);
        mageService.fabuMage(mage);

        ArrayList<Mage> mages = mageService.xianshiMag();;
        HttpSession session1 = request.getSession();
        session1.setAttribute("mages",mages);

        response.sendRedirect(request.getContextPath()+"/main.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
