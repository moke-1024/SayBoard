package com.sayboard.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;

/**
 * @outhor moke
 * @date 2019-11-25
 */
@WebFilter(filterName = "EncodingFilter",value = "/*")
public class  EncodingFilter implements Filter {
    public boolean use_encode = true;
    public String encode = null;
    public void init(FilterConfig config) throws ServletException {
        ServletContext sc = config.getServletContext();
        boolean use_encode = Boolean.parseBoolean(sc.getInitParameter("use_encode"));
        this.use_encode = use_encode;

        String encode = sc.getInitParameter("encode");
        this.encode =encode;
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request =
                use_encode?new MyHttpServletRequest((HttpServletRequest) req,encode):
                        (HttpServletRequest) req;
        resp.setContentType("text/html;charset="+encode);
        chain.doFilter(request, resp);
    }
}
