package lt.daujotas.filter;

import jakarta.servlet.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Log4j2
public class MyKeyGenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.trace("----> My filter Implementation :::::Befor::: do Filter chain-------->");


        filterChain.doFilter(servletRequest, servletResponse);

        log.trace("----> My filter Implementation :::::After::: do Filter chain-------->");


    }


}
