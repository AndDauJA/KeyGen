package lt.daujotas.controlers.Users;


import jakarta.validation.Valid;
import lt.daujotas.clients.ClientAccountInfo;
import lt.daujotas.service.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ClientRegistrationControler {

    @Autowired
    private ClientAccountService clientAccountService;

    @GetMapping("/registrationform")
    public String showLoginForm(Model model) {
        model.addAttribute("clientAccountInfo", new ClientAccountInfo());
        return "brigama/registrationform"; // kelias iki failo
    }

    @PostMapping("/registrationform")
    public String createLoginClient(Model model, @Valid ClientAccountInfo clientAccountInfo, BindingResult errors) {

        if(errors.hasErrors()){

            return "brigama/registrationform";
        }

        clientAccountService.saveClient(clientAccountInfo);

        return "redirect:/client/clientTestWeb";

    }
}