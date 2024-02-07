package lt.daujotas.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Date;

@ControllerAdvice
public class GlobalModelAttributeAdvice {
    @ModelAttribute("modelDateAttr")  // modelDate is optional here, HTML will use now (as method name)
    public Date now() {
        return new Date();
    }

    @ModelAttribute("modelCurrencyAttr")
    public char currency() {
        return '€';
    }
}