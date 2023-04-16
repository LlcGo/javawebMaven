package com.lc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author Lc
 * @Date 2023/4/16
 * @Description 创建servlet应用程序,通用写法,继承HttpServlet类,提供doget和dopost
 */
public class LoginServlet extends HttpServlet {
    /**
     * 处理get请求 如果是get就直接容器调用这个方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("------LoginServlet doget ------");
    }

    /**
     * 处理的是post请求
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //中文进来会出现乱码
        //乱码了就去过滤器里面 设置

        //模拟用户登录
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        String initName = this.getServletConfig().getInitParameter("initName");
        String initPwd = this.getServletConfig().getInitParameter("initPwd");

        if(initName.equals(uname) && initPwd.equals(upwd)){
            req.getSession().setAttribute("loginUser",uname);
            req.getRequestDispatcher("success.jsp").forward(req,resp);
            return;
        }

        resp.sendRedirect("login.jsp");

    }
}
