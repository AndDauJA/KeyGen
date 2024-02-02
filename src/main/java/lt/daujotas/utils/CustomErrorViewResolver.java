package lt.daujotas.utils;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
@Component
public class CustomErrorViewResolver implements ErrorViewResolver {


    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {

        if(status ==HttpStatus.NOT_FOUND) {
           return new ModelAndView("errors/404", model);

       }

       return new ModelAndView("customErrorPage", model);
    }
}
