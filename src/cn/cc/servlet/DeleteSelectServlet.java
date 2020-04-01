package cn.cc.servlet;

import cn.cc.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteSelectServlet")
public class DeleteSelectServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取被选中的所有uid值
        String[] uids = request.getParameterValues("uid");
        //数组不为空时，调用删除用户的service
        if (uids.length != 0 && uids != null) {
            UserServiceImpl userService = new UserServiceImpl();
            userService.deleteSelect(uids);
        }
        response.sendRedirect(request.getContextPath()+"/userListServlet");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
