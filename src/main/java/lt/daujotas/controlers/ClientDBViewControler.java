package lt.daujotas.controlers;

import lt.daujotas.clientPojo.ClientData;
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

@Controller
public class ClientDBViewControler {

    private final ClientAccountService clientAccountService;

    @Autowired
    public ClientDBViewControler(ClientAccountService clientAccountService) {
        this.clientAccountService = clientAccountService;
    }

    @GetMapping("/dbview")  //sitas turi sutapti su return
    public String dataBAseViewForm(Model model, @PageableDefault(size = 25,
            sort = {"firstName"}, direction = Sort.Direction.ASC) Pageable pageable) {

        final Page<ClientData> clientAccounts = clientAccountService.getAllClientsPages(pageable);
        model.addAttribute("clientList", clientAccounts);
        return "dbview";   // kelias iki failo

    }


    @Transactional
    @GetMapping("/dbview/{userName}/delete")
    public String deleteClient(@PathVariable String userName) {
        clientAccountService.deleteClientByUserName(userName);
        return "redirect:/dbview";
    }
}



