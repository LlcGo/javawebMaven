package com.lc;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author Lc
 * @Date 2023/4/16
 * @Description 第一个过滤器
 */
public class FristFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("------FristFilter init------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("------FristFilter doFilter------");
        //请求放行 可以将其交给后续的servlet程序
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("------FristFilter destroy------");
    }
}
