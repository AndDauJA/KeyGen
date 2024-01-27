package lt.daujotas.controlers;


import lt.daujotas.clients.ClientAccountInfo;
import lt.daujotas.service.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ClinetAccUpdateControler {

    @Autowired
    ClientAccountService clientAccountService;

//    @GetMapping("/updateclient")
//    public String showFindClientForm(Model model) {
//        model.addAttribute("findClient", new ClientAccountInfo());
////        model.addAttribute("clientList", clientAccountService.getAllClients());
//        return "brigama/clientaccountform";
//    }

//    @PostMapping("/updateclient")
//    public String findAndUpdateClient(Model model, @ModelAttribute ClientAccountInfo findClient,  BindingResult errors) {
//
//        if(errors.hasErrors()){
//
//            return "brigama/clientaccountform";
//        }
//
//        clientAccountService.updateClient(findClient);
//
//
//
//        return "brigama/clientaccountform";
//    }

}
