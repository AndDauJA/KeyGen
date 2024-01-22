package lt.daujotas.controlers;


import lt.daujotas.clients.ClientAccountInfo;
import lt.daujotas.service.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/client")
public class FindClientCntroler {
    @Autowired
    ClientAccountService clientAccountService;

    @GetMapping("/findClient")
    public String showFindClientForm(Model model) {
        model.addAttribute("findClient", new ClientAccountInfo());
        model.addAttribute("clientList", clientAccountService.getAllClients());
        return "/findClient";
    }


    @PostMapping("/findClient")
    public String findClient(@ModelAttribute ClientAccountInfo findClient, Model model) {
//        Optional<ClientAccountInfo> client = clientAccountService.getClientByUUID(findClient.getUuid());
        Optional<ClientAccountInfo>clientByName=clientAccountService.getClientByFirstName(findClient.getFirstName());
        if (clientByName.isPresent()) {
            model.addAttribute("findClient", clientByName.get());
        } else {
            model.addAttribute("error", "Client not found");
        }
//        model.addAttribute("clientList", clientAccountService.getAllClients());
        return "/findClient";
    }

}
