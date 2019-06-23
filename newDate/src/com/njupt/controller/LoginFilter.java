package com.njupt.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huhui on 2017/12/8.
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String servletPath=httpServletRequest.getServletPath();
        if (servletPath.contains("login.form")||servletPath.contains("register.form")){
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }
        Object user= httpServletRequest.getSession().getAttribute("user_information");
        if(user==null){
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+"/html/user.html");
            return;
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    @Override
    public void destroy() {

    }
}
