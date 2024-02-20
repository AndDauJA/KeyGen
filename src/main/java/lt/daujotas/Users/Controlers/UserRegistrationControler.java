package lt.daujotas.Users.Controlers;


import jakarta.validation.Valid;
import lt.daujotas.dto.ClientDto;
import lt.daujotas.service.UsersRegistrationSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserRegistrationControler {

    private UsersRegistrationSerivce usersRegistrationSerivce;

    @Autowired
    public UserRegistrationControler(UsersRegistrationSerivce usersRegistrationSerivce) {
        this.usersRegistrationSerivce = usersRegistrationSerivce;
    }

    @GetMapping("/userregistrationform")
    public String showLoginForm(Model model) {
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
            if (e.getMessage().contains("EMAIL"))
                errors.addError(new FieldError(ClientDto.class.getName(), "emailAddress", "This email already in use"));
        }   // TODO pabaigti kad mestu message
//        clientAccountService.saveClient(clientData);

        return "redirect:brigama/login";

    }
}
