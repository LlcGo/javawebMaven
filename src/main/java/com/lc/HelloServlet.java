package com.lc;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author Lc
 * @Date 2023/4/16
 * @Description 第一个servlet应用程序，原始写法
 * 定义：凡是运行在一个服务器端，并实现了servletApi或者继承了实现了servlet的类
 * 作用：用于接收客户端的请求，调用业务处理类中核心处理方法，并处理当前请求，并响应给客户端，很少做业务处理
 *
 * servlet生命周期小结：
 * 1.创建servlet应用程序的实例。执行一次，默认通过url-pattern映射到servlet应用程序，才会创建实例（容器执行）
 * 2.初始化servlet应用程序，调用init，执行一次，创建完实例后，容器立即调用
 * 3.servlet应用处理请求，service，执行多次
 * 4.销毁servlet应用程序，关闭容器时候卸载程序，立即调用destroy，主要用于释放servlet占用资源
 */


public class HelloServlet implements Servlet {
    /**
     * 空参构造，tomcat通过反射创建servlet的实例对象
     */
    public HelloServlet() {
        System.out.println("------HelloServlet HelloServlet空参构造 实例化-------");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("------HelloServlet init-------");
        //获取部署时候的配置在标签的init-param
        String inintKey = servletConfig.getInitParameter("inintKey");
        System.out.println(inintKey);
    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("------HelloServlet ServletConfig-------");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("------HelloServlet  service-------");
        //获取请求参数,于jsp中接收参数一致
        String username = servletRequest.getParameter("username");
        System.out.println("username="+username);
        //响应结果
        //1.直接响应数据
//        PrintWriter out = servletResponse.getWriter();
//        out.print("Success");
        //2.直接通过转发或者重定向跳转页面
        servletRequest.getRequestDispatcher("success.jsp").forward(servletRequest,servletResponse);
    }

    @Override
    public String getServletInfo() {
        System.out.println("------HelloServlet  getServletInfo-------");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("------HelloServlet  destroy-------");
    }
}
