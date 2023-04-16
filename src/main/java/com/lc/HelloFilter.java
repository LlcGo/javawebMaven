package com.lc;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author Lc
 * @Date 2023/4/16
 * @Description 第一个过滤器
 * 定义：凡是实现javax.servlet.Filter接口类 就是一个过滤器
 * 作用：过滤信息，决定是否交给servlet应用程序处理，并对响应请求进行处理，是客户端和servlet应用程序的中间层
 * 先filter 后 servlet
 *
 * filter过滤器链的顺序可以由xml映射的路径的前后来判断 过滤器的执行顺序，先配置先过滤
 */
public class HelloFilter implements Filter {

    public HelloFilter() {
        System.out.println("filter初始化,容器启动之前初始化");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("------HelloFilter init------");
        //全局参数也可以取到
        String filterKey = filterConfig.getInitParameter("filterKey");
        System.out.println(filterKey);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("------HelloFilter doFilter------");
        //请求放行 可以将其交给后续的servlet程序
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("------HelloFilter destroy------");
    }
}
