package lt.daujotas.controlers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginToAccControler {

    @GetMapping("/login")
    public String showLoginForm (Model model) {
//        model.addAttribute("createClientAccount", new ClientAccountPojo());
        return "/brigama/login"; // kelias iki failo
    }
}
