
package lt.daujotas.Users.Controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginToAccControler {
    public LoginToAccControler() {
    }

    @GetMapping({"/login"})
    public String showLoginForm(Model model) {
        return "brigama/login";
    }
}