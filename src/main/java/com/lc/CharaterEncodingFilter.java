package com.lc;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Author Lc
 * @Date 2023/4/16
 * @Description 设置过中文过滤器
 */
public class CharaterEncodingFilter implements Filter {

    private String enconding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.enconding = filterConfig.getInitParameter("enconding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(enconding);
        response.setCharacterEncoding(enconding);
        response.setContentType("text/html;charset=UTF-8");
        //将设置好字符集的req给下面的所有的req response也一样
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
