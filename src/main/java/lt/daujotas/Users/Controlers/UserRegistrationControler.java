package lt.daujotas.Users.Controlers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lt.daujotas.dto.ClientDto;
import lt.daujotas.service.UsersRegistrationSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class UserRegistrationControler {

    private UsersRegistrationSerivce usersRegistrationSerivce;

    @Autowired
    public UserRegistrationControler(UsersRegistrationSerivce usersRegistrationSerivce) {
        this.usersRegistrationSerivce = usersRegistrationSerivce;
    }

    @GetMapping("/userregistrationform")
    public String showLoginForm(Model model, HttpServletRequest request) {
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            System.out.println("Session errorMessage: " + session.getAttribute("errorMessage"));
//        }
        //TODO pakoreguoti kad tikrintu ir mestu info jog toks username jau yra ir email taip pat

        model.addAttribute("clientDto", ClientDto.builder().build());
        return "brigama/userregistrationform"; // kelias iki failo
    }

    @PostMapping("/userregistrationform")
    public String registerNewUser(Model model, @Valid ClientDto clientDto, BindingResult errors) {


        if (errors.hasErrors()) {

            return "brigama/userregistrationform";
        }

        try {
            usersRegistrationSerivce.register(clientDto);
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().contains("EMAIL")) {
                String duplicateEmailMessage = "This email already in use";
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
