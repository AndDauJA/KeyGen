package lt.daujotas.Users.Controlers;


import jakarta.validation.Valid;
import lt.daujotas.Users.clientData.ClientData;
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


    @GetMapping("/login")
    public String showLoginForm(Model model) {
//        model.addAttribute("clientLoginInfo", new ClientLoginInfo());
        return "brigama/login"; // kelias iki failo
    }
//
//    @PostMapping("/login")
//    public String createLoginClient(Model model, @Valid ClientData clientData, BindingResult errors) {
//        model.addAttribute("clientData", clientData);
//        if(errors.hasErrors()){
//            return "brigama/login";
//        }
//
//
//        return "redirect:brigama/clientaccountform";
//
//    }
}
