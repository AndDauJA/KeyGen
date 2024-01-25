package lt.daujotas.Users.Controlers;


import jakarta.validation.Valid;
import lt.daujotas.clients.ClientLoginInfo;


import lt.daujotas.service.ClientLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginToAccControler {

    @Autowired
    private ClientLoginService clientLoginService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("clientLoginInfo", new ClientLoginInfo());
        return "brigama/login"; // kelias iki failo
    }

    @PostMapping("/login")
    public String createLoginClient(Model model,@Valid ClientLoginInfo clientLoginInfo, BindingResult errors) {
        if(errors.hasErrors()){
            return "brigama/login";
        }
        clientLoginService.saveLoginClient(clientLoginInfo);

        return "redirect:/client/clientTestWeb";

    }
}
