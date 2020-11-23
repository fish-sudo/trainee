package cn.com.filter;

import cn.com.config.JDBCAndChatContentCconfig;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 过滤器用于设置字符集编码和判断用户是否登录
 */
public class Filter implements javax.servlet.Filter {
    private FilterConfig config;
    public void destroy() {
    }
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding(config.getInitParameter("res"));
        resp.setContentType(config.getInitParameter("resp"));
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

}
