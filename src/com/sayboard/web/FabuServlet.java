package com.sayboard.web;

import com.sayboard.domain.Mage;
import com.sayboard.domain.User;
import com.sayboard.exception.MsgException;
import com.sayboard.service.MageService;
import com.sayboard.service.UserService;
import com.sayboard.utils.WebUtil;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

        if (WebUtil.isNull(acceptname)){
            request.setAttribute("msg1","接收人不能为空");
            request.getRequestDispatcher("/fabu.jsp").forward(request,response);
            return;
        }

        UserService userService = new UserService();

        MageService mageService = new MageService();
        Mage mage = new Mage(0,sendname,time,acceptname,say);
        session.setAttribute("mage",mage);

        try {
            boolean flag = userService.findacceptUser(acceptname);
            mageService.fabuMage(mage,flag);
        }catch (MsgException e){
            request.setAttribute("msg1",e.getMessage());
            request.getRequestDispatcher("/fabu.jsp").forward(request,response);
            return;
        }

        List<Mage> mages = mageService.xianshiByNameMag(sendname);
        session.setAttribute("mages",mages);

        response.sendRedirect(request.getContextPath()+"/main.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
