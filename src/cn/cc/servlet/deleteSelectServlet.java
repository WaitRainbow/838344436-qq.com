package cn.cc.servlet;

import cn.cc.service.impl.userServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/deleteSelectServlet")
public class deleteSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取被选中的所有uid值
        String[] uids = request.getParameterValues("uid");
        //数组不为空时，调用删除用户的service
        if (uids.length != 0 && uids != null) {
            userServiceImpl userService = new userServiceImpl();
            userService.deleteSelect(uids);
        }
        response.sendRedirect(request.getContextPath()+"/userListServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
