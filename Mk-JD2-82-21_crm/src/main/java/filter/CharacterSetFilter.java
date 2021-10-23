package filter;



import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;



@WebFilter(filterName = "DispatcherFilter", urlPatterns = { "/*" })
public class CharacterSetFilter implements Filter {

    private static final Logger log = Logger.getLogger(CharacterSetFilter.class);

    @Override
    public void init(FilterConfig filterConfig){
        log.info("Init CharacterSetFilter");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("Destroy CharacterSetFilter");
    }
}
