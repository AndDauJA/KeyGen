package lt.daujotas.controlers;


import lt.daujotas.clients.ClientAccountPojo;
import lt.daujotas.clients.ClientLoginPojo;
import lt.daujotas.service.ClientAccountService;
import lt.daujotas.service.ClientLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        model.addAttribute("clientRegistration", new ClientAccountPojo());
        return "brigama/registrationform"; // kelias iki failo
    }

    @PostMapping("/registrationform")
    public String createLoginClient(ClientAccountPojo clientAccountPojo) {
        clientAccountService.saveClient(clientAccountPojo);

        return "redirect:/client/clientTestWeb";

    }
}
