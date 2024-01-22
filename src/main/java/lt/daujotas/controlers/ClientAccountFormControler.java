package lt.daujotas.controlers;


import jakarta.validation.Valid;
import lt.daujotas.clients.ClientAccountInfo;
import lt.daujotas.service.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller

public class ClientAccountFormControler {

    @Autowired
    ClientAccountService clientAccountService;

    @GetMapping("/clientaccountform")
    public String showLoginForm(Model model) {
        model.addAttribute("clientAccountInfo", new ClientAccountInfo());
        return "brigama/clientaccountform"; // kelias iki failo
    }

    @PostMapping("/clientaccountform")
    public String createLoginClient(Model model, @Valid ClientAccountInfo clientAccountInfo, BindingResult errors) {

        if(errors.hasErrors()){

            return "brigama/clientaccountform";
        }

        clientAccountService.saveClient(clientAccountInfo);

        return "redirect:/client/clientTestWeb";

    }

}
