package lt.daujotas.Users.Controlers;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lt.daujotas.Users.clientData.ClientData;
import lt.daujotas.dto.ClientDto;
import lt.daujotas.service.UsersRegistrationSerivce;
import lt.daujotas.validation.PasswordMatchValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class UserRegistrationControler {


    @Autowired
    private UsersRegistrationSerivce usersRegistrationSerivce;


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
        usersRegistrationSerivce.register(clientDto);
//        clientAccountService.saveClient(clientData);

        return "redirect:/client/clientTestWeb";

    }
}
