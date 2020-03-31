package cn.cc.servlet;

import cn.cc.domain.PageBean;
import cn.cc.domain.User;
import cn.cc.service.impl.userServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/userListByPageServlet")
public class userListByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取当前页面参数
        String currentPage = request.getParameter("currentPage");
        if(currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }

        //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();
        //根据条件查询
        userServiceImpl userService = new userServiceImpl();
        PageBean<User> pb = userService.findByCondition(currentPage,condition);
        //回写查询结果
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
