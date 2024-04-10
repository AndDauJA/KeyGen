package lt.daujotas.Users.Controlers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lt.daujotas.dto.ClientDto;
import lt.daujotas.service.UsersRegistrationSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;


@Controller
@RequestMapping
public class UserRegistrationControler {

    private UsersRegistrationSerivce usersRegistrationSerivce;
    private static final Logger log = LoggerFactory.getLogger(UserRegistrationControler.class);
    @Autowired
    private MessageSource messageSource;

    @Autowired
    public UserRegistrationControler(UsersRegistrationSerivce usersRegistrationSerivce) {
        this.usersRegistrationSerivce = usersRegistrationSerivce;
    }

    @GetMapping("/userregistrationform")
    public String showLoginForm(Model model, HttpServletRequest request) {

        //TODO pakoreguoti kad tikrintu ir mestu info jog toks username jau yra ir email taip pat

        model.addAttribute("clientDto", ClientDto.builder().build());
        return "brigama/userregistrationform"; // kelias iki failo
    }

    @PostMapping("/userregistrationform")
    public String registerNewUser(Model model, @Valid ClientDto clientDto, BindingResult errors, Locale locale) {


        if (errors.hasErrors()) {

            return "brigama/userregistrationform";
        }

        try {
            usersRegistrationSerivce.register(clientDto);
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().contains("emailaddress") || e.getMessage().contains("UK_h6xys3okd86n206wvado39ien")) {
                String duplicateEmailMessage = messageSource.getMessage("duplicate.email.message", null, locale);
                model.addAttribute("duplicateEmailMessage", duplicateEmailMessage);
                return "brigama/userregistrationform";
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "redirect:brigama/login";
    }

    @ControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(DataIntegrityViolationException.class)
        public String handleDataIntegrityViolationException(Model model, DataIntegrityViolationException ex) {
            model.addAttribute("duplicateEmailMessage", "This email already in use");
            return "brigama/userregistrationform";
        }
    }


}
