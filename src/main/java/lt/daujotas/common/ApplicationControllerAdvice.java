package lt.daujotas.common;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lt.daujotas.exception.ClientNotFoundException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

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
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ModelAndView handleDataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (ex.getMessage().contains("EMAIL")) {
            session.setAttribute("errorMessage", "This email is already in use.");
        } else {
            session.setAttribute("errorMessage", "A data integrity error occurred.");
        }
        return new ModelAndView("redirect:/userregistrationform");
    }
}
