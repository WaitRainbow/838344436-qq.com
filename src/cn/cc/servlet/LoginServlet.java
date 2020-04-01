package cn.cc.servlet;

import cn.cc.domain.Manager;
import cn.cc.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");
        //获取参数

//        String username= parameterMap.get("username")[0];
//        String password= parameterMap.get("password")[0];

        String checkcode = req.getParameter("checkcode");
        //获取session中保存的验证码并删除缓存的验证码
        HttpSession session = req.getSession();
        String checked = (String) session.getAttribute("checkcode");
        session.removeAttribute("checkcode");
        //验证码不正确 后面的操作就没有必要
        if (checkcode==null || !checkcode.equalsIgnoreCase(checked)) {
            req.setAttribute("login_msg","验证码错误！");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }
        //验证码正确
        //判断用户名和密码
        Map<String, String[]> parameterMap = req.getParameterMap();
        Manager manager = new Manager();
        try {
            BeanUtils.populate(manager,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //调用数据库服务
        UserServiceImpl userService = new UserServiceImpl();
        Manager result = userService.login(manager);


        if (result == null) {
            //登录失败
            req.setAttribute("login_msg","用户名或密码错误！");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            //登录成功
            session.setAttribute("user",result);
            resp.sendRedirect(req.getContextPath()+"/userListServlet");

        }
    }

}
