package lt.daujotas.controlers;


import lt.daujotas.dto.ClientDto;
import lt.daujotas.service.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/clientaccountform")
    public String showClientForm(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            // Nukreipkite vartotoją į prisijungimo puslapį arba grąžinkite klaidos pranešimą
            return "redirect:/login"; // arba rodykite klaidos pranešimą
        }
        String username = authentication.getName();
        Optional<ClientDto> clientByUserName = clientAccountService.getClientByUserName(username);
        if (clientByUserName.isPresent()) {
            ClientDto foundClient = clientByUserName.get();
            model.addAttribute("clientDto", foundClient);
        } else {
            model.addAttribute("error", "Client not found");
        }
//        model.addAttribute("clientDto", new ClientDto());
//        model.addAttribute("clientDto", ClientDto.builder().build());
        return "brigama/clientaccountform";
    }



    @PreAuthorize("hasRole('USER')")
    @PostMapping("/updateclient")
    public String updateClient(@ModelAttribute ClientDto clientDto, BindingResult error, Model model) {
        if (error.hasErrors()) {
            // Įvyko klaida validuojant formos duomenis
            return "brigama/clientaccountform"; // Grįžti atgal į formą su klaidomis
        }
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String username = authentication.getName();
            if (clientDto.getUserName().equals(username)) {
                clientAccountService.updateAllClientData(
                        clientDto.getUserName(),
                        clientDto.getFirstName(),
                        clientDto.getLastName(),
                        clientDto.getMiddleName(),
                        clientDto.getPostAddres(),
                        clientDto.getPhoneNumber(),
                        clientDto.getEmailAddress(),
                        clientDto.getDateofbirth(),
                        clientDto.getGender());

                model.addAttribute("clientDto", clientDto);
                model.addAttribute("success", true);
            } else {
                model.addAttribute("error", "Unauthorized to update other user's data");
            }
        } catch (Exception e) {
            model.addAttribute("error", "Failed to update client");
            System.out.println(e.getMessage());
            model.addAttribute("clientDto", clientDto);
        }

        return "redirect:/clientaccountform";

//TODO papildyti update client password metodu

    }
}


