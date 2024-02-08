package lt.daujotas.controlers;


import lt.daujotas.Users.clientDataPojo.ClientData;
import lt.daujotas.dto.ClientDto;
import lt.daujotas.service.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller

public class ClientAccountControler {

    ClientAccountService clientAccountService;
    @Autowired
    public ClientAccountControler(ClientAccountService clientAccountService) {
        this.clientAccountService = clientAccountService;
    }

    @GetMapping("/clientaccountform")
    public String showFindClientForm(Model model) {
        model.addAttribute("clientData", new ClientData());
//        model.addAttribute("clientDto", ClientDto.builder().build());
        return "brigama/clientaccountform";
    }


    @PostMapping("/clientaccountform")

    public String findClient(@ModelAttribute ClientData clientData, Model model) {

//        Optional<ClientAccountInfo> client = clientAccountService.getClientByUUID(findClient.getUuid());
//        Optional<ClientAccountInfo> clientByName = clientAccountService.getClientByFirstName(findClient.getFirstName());
        Optional<ClientData> clientByUserName = clientAccountService.getClientByUserName(clientData.getUserName());


        if (clientByUserName.isPresent()) {
            ClientData foundClient=clientByUserName.get();
            model.addAttribute("clientData", foundClient);
        } else {
            model.addAttribute("error", "Client not found");
        }


        return "brigama/clientaccountform";
    }

    //    @PostMapping("/updateclient")
//    public String updateClient(@ModelAttribute ClientData clientData, Model model) {
//        try {
//                        clientAccountService.updateAllClientData(clientData);
//                        // Perduodame atnaujintą klientą į šabloną
//            model.addAttribute("clientData", clientData);
//            model.addAttribute("success", "Client updated successfully");
//        } catch (Exception e) {
//            model.addAttribute("error", "Failed to update client");
//        }
//
//        return "brigama/clientaccountform";
//    }
    @PostMapping("/updateclient")
    public String updateClient(@ModelAttribute ClientData clientData, Model model) {
        try {
            clientAccountService.updateAllClientData(
                    clientData.getUserName(),
                    clientData.getFirstName(),
                    clientData.getLastName(),
                    clientData.getMiddleName(),
                    clientData.getPostAddres(),
                    clientData.getPhoneNumber(),
                    clientData.getEmailAddress());

            model.addAttribute("clientData", clientData);
            model.addAttribute("success", "Client updated successfully");
        } catch (Exception e) {
            model.addAttribute("error", "Failed to update client");
        }

        return "brigama/clientaccountform";

//TODO papildyti update client password metodu

    }
}


