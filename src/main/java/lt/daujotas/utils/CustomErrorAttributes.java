package lt.daujotas.utils;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
@Component
public class CustomErrorAttributes extends DefaultErrorAttributes {

    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        final Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, options);
        errorAttributes.put("myCustomAttribute", "Custom Attribute");

        return errorAttributes;
    }
}
