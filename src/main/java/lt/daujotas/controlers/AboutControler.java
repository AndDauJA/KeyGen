package lt.daujotas.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class AboutControler {
    @GetMapping("/aboutform")
    public String showAboutForm(Model model) {

        return "brigama/aboutform";
    }
}
