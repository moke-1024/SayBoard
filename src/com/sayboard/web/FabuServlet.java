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

        Date date = new Date() ;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(date);

        String acceptname = request.getParameter("textfield");
        String say = request.getParameter("textfield2");


        MageService mageService = new MageService();
        Mage mage = new Mage(0,sendname,time,acceptname,say);
        session.setAttribute("mage",mage);
        mageService.fabuMage(mage);


        String userName = sendname;

        ArrayList<Mage> mages = mageService.xianshiByNameMag(userName);
        session.setAttribute("mages",mages);

        String allname = "所有人";
        ArrayList<Mage> mages1 = mageService.xianshiByNameMag(allname);
        session.setAttribute("mages1",mages1);

        response.sendRedirect(request.getContextPath()+"/main.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
