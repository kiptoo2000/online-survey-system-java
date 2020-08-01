package filters;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AuthFilter implements Filter {
    private FilterConfig filterConfig = null;
    public AuthFilter() {
    }
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
      try {

            // check whether session variable is set
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession ses = req.getSession(false);
            //  allow user to proccede if url is login.jsp or user logged in
            if ( req.getRequestURI().indexOf("/login.jsp") >= 0 ||
                     (ses != null && ses.getAttribute("uname") != null) )
                   chain.doFilter(request, response);
            else  // user didn't log in but asking for a page that is not allowed so take user to login page
                   res.sendRedirect(req.getContextPath() + "/faces/login.jsp");  // Anonymous user. Redirect to login page
      }
     catch(Throwable t) {
         System.out.println( t.getMessage());
     }
    }

    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
    public void destroy() {
    }
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }
}
