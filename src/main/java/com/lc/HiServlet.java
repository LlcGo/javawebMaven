package com.lc;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author Lc
 * @Date 2023/4/16
 * @Description 第二个servlet应用程序，原始写法
 *关闭容器时候卸载程序，立即调用destroy，主要用于释放servlet占用资源
 */


public class HiServlet implements Servlet {
    /**
     * 空参构造，tomcat通过反射创建servlet的实例对象
     */
    public HiServlet() {
        System.out.println("------HelloServlet HelloServlet2空参构造 实例化-------");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("------HelloServlet init2-------");

    }

    @Override
    public ServletConfig getServletConfig() {
        System.out.println("------HelloServlet ServletConfig2-------");
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("------HelloServlet  service2-------");
    }

    @Override
    public String getServletInfo() {
        System.out.println("------HelloServlet  getServletInfo2-------");
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("------HelloServlet  destroy2-------");
    }
}
