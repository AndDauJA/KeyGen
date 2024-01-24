package lt.daujotas.controlers;

import lt.daujotas.clients.ClientAccountInfo;
import lt.daujotas.service.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;


@Controller
public class ClientDBViewControler {

    @Autowired
    private ClientAccountService clientAccountService;


    @GetMapping("/dbview")  //sitas turi sutapti su return
    public String dataBAseViewForm(Model model, @PageableDefault(size = 5, sort = {"firstName"}, direction = Sort.Direction.ASC) Pageable pageable) {

        final Page<ClientAccountInfo> clientAccounts = clientAccountService.getAllClientsPages(pageable);
        model.addAttribute("clientList", clientAccounts);
        return "dbview";   // kelias iki failo

    }


    @Transactional
    @GetMapping("/dbview/{uuid}/delete")
    public String deleteClient(@PathVariable String uuid) {
        clientAccountService.deleteClientByUUID(UUID.fromString(uuid));
        return "redirect:/dbview";
    }
}



