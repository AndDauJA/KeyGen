package lt.daujotas.Users.Controlers;


import jakarta.validation.Valid;
import lt.daujotas.Users.clientData.ClientData;
import lt.daujotas.service.ClientAccountService;
import lt.daujotas.service.UsersRegistrationSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class UserRegistrationControler {

    @Autowired
    private ClientAccountService clientAccountService;
    @Autowired
    private UsersRegistrationSerivce usersRegistrationSerivce;

    @GetMapping("/userregistrationform")
    public String showLoginForm(Model model) {
        model.addAttribute("clientData", new ClientData());
        return "brigama/userregistrationform"; // kelias iki failo
    }

    @PostMapping("/userregistrationform")
    public String createLoginClient(Model model, @Valid ClientData clientData, BindingResult errors) {

        if (errors.hasErrors()) {

            return "brigama/userregistrationform";
        }
        usersRegistrationSerivce.register(clientData);
//        clientAccountService.saveClient(clientData);

        return "redirect:/client/clientTestWeb";

    }
}
