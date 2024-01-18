package lt.daujotas.controlers;


import lt.daujotas.clients.ClientLoginInfo;


import lt.daujotas.service.ClientLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginToAccControler {

    @Autowired
    private ClientLoginService clientLoginService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("clientLogin", new ClientLoginInfo());
        return "brigama/login"; // kelias iki failo
    }

    @PostMapping("/login")
    public String createLoginClient(ClientLoginInfo clientLoginInfo) {
        clientLoginService.saveLoginClient(clientLoginInfo);

        return "redirect:/client/clientTestWeb";

    }
}
