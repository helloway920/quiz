package filter;


import com.example.quiz.entity.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
