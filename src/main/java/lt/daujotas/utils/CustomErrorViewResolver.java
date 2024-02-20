//package lt.daujotas.utils;
//
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class CustomErrorViewResolver implements ErrorViewResolver {
//
//
//    // nuo nulio perrasem error
//
//    @Override
//    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
//
//        if (status == HttpStatus.NOT_FOUND) {
//            return new ModelAndView("errors/404", model);
//
//        }
//       final Map<String, Object> myModelMap = new HashMap<>();
//        myModelMap.putAll(model);
//        myModelMap.put("myCustomAttribute", "Any text for attribute");
//        return new ModelAndView("customErrorPage", myModelMap);
//    }
//}
