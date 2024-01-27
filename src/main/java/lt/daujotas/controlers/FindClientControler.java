package lt.daujotas.controlers;


import lt.daujotas.Users.dto.ClientDto;
import lt.daujotas.clients.ClientAccountInfo;
import lt.daujotas.service.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller

public class FindClientControler {
    @Autowired
    ClientAccountService clientAccountService;

    @GetMapping("/clientaccountform")
    public String showFindClientForm(Model model) {
        model.addAttribute("clientDto", new ClientDto());
//        model.addAttribute("clientList", clientAccountService.getAllClients());
        return "brigama/clientaccountform";
    }


    @PostMapping("/clientaccountform")

    public String findClient(@ModelAttribute ClientDto clientDto, Model model) {

//        Optional<ClientAccountInfo> client = clientAccountService.getClientByUUID(findClient.getUuid());
//        Optional<ClientAccountInfo> clientByName = clientAccountService.getClientByFirstName(findClient.getFirstName());
        Optional<ClientDto> clientByUserName = clientAccountService.getClientByUserName(clientDto.getUserName());
        if (clientByUserName.isPresent()) {
            model.addAttribute("clientDto",  clientByUserName.get());
        } else {
            model.addAttribute("error", "Client not found");
        }

//        model.addAttribute("clientList", clientAccountService.getAllClients());
        return "brigama/clientaccountform";
    }

    @PostMapping("/updateclient")
    public String updateClient(@ModelAttribute ClientDto updatedClient, Model model) {
        try {
            System.out.println(updatedClient);
            clientAccountService.updateClient(updatedClient);
            
            // Perduodame atnaujintą klientą į šabloną
            model.addAttribute("clientDto", updatedClient);
            model.addAttribute("success", "Client updated successfully");
        } catch (Exception e) {
            model.addAttribute("error", "Failed to update client");
        }

        return "brigama/clientaccountform";
    }


}


