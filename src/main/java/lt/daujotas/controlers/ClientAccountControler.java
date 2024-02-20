package lt.daujotas.controlers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lt.daujotas.dto.ClientDto;
import lt.daujotas.service.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller

public class ClientAccountControler {

    ClientAccountService clientAccountService;

    @Autowired
    public ClientAccountControler(ClientAccountService clientAccountService) {
        this.clientAccountService = clientAccountService;
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/clientaccountform")
    public String showFindClientForm(Model model) {
        model.addAttribute("clientDto", new ClientDto());
//        model.addAttribute("clientDto", ClientDto.builder().build());
        return "brigama/clientaccountform";
    }


    @PostMapping("/clientaccountform")

    public String findClient(@ModelAttribute ClientDto clientDto, Model model) {

//        Optional<ClientAccountInfo> client = clientAccountService.getClientByUUID(findClient.getUuid());
//        Optional<ClientAccountInfo> clientByName = clientAccountService.getClientByFirstName(findClient.getFirstName());
        Optional<ClientDto> clientByUserName = clientAccountService.getClientByUserName(clientDto.getUserName());


        if (clientByUserName.isPresent()) {
            ClientDto foundClient = clientByUserName.get();
            model.addAttribute("clientDto", foundClient);
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
    public String updateClient(@ModelAttribute ClientDto clientDto, Model model) {
        try {
            clientAccountService.updateAllClientData(
                    clientDto.getUserName(),
                    clientDto.getFirstName(),
                    clientDto.getLastName(),
                    clientDto.getMiddleName(),
                    clientDto.getPostAddres(),
                    clientDto.getPhoneNumber(),
                    clientDto.getEmailAddress());

            model.addAttribute("clientDto", clientDto);
            model.addAttribute("success", true);
        } catch (Exception e) {
            model.addAttribute("error", "Failed to update client");
        }

        return "brigama/clientaccountform";

//TODO papildyti update client password metodu

    }

//    @GetMapping("/logout")
//    public String logout() {
//        // Atsijungiame naudotoją
//        SecurityContextHolder.clearContext();
//        return "redirect:/"; // Peradresuojame į prisijungimo puslapį su logout parametru
//    }
//    @RequestMapping("/logout")
//    public String logout(HttpServletRequest request) {
//        // Išvalome sesijos duomenis
//        HttpSession session = request.getSession(false);
//        if (session != null) {
//            session.invalidate();
//        }
//        // Grįžtame į prisijungimo puslapį arba kitą nurodytą vietą
//        return "redirect:/login";
//    }
}


