package lt.daujotas.common;

import lt.daujotas.exception.ClientNotFoundException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class ApplicationControllerAdvice {
    @ExceptionHandler
    public String productNotFound(ClientNotFoundException e, Model model) {
        model.addAttribute("productUUID", e.getClientUUID());
        return "/error/clienttNotFound";
    }

    @ExceptionHandler
    public String otherErrors(Exception e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, trimmerEditor);
    }
}
