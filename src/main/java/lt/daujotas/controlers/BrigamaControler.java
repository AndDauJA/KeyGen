package lt.daujotas.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BrigamaControler {


    @GetMapping("/brigamaHome")
    public String showCreateForm(Model model) {
//        model.addAttribute("createClientAccount", new ClientAccountPojo());
        return "brigama/index"; // kelias iki failo
    }
}
