package com.sayboard.web;

import com.sayboard.domain.Mage;
import com.sayboard.domain.User;
import com.sayboard.service.MageService;

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
 * @date 2019-11-27
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int deleteid = Integer.valueOf(request.getParameter("id"));

        MageService mageService = new MageService();
        mageService.deleteMage(deleteid);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        List<Mage> mages = mageService.xianshiByNameMag(user.getEmpName());
        session.setAttribute("mages",mages);

        response.sendRedirect(request.getContextPath()+"/main.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
