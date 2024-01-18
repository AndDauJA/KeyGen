package lt.daujotas.controlers;

import lt.daujotas.clients.ClientAccountInfo;
import lt.daujotas.service.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ClientDBViewControler {

    @Autowired
    private ClientAccountService clientAccountService;
    @GetMapping("/dbview")  //sitas turi sutapti su return
    public String dataBAseViewForm(Model model, Pageable pageable){
        try {
            final Page<ClientAccountInfo> clientAccounts = clientAccountService.getAllClientsPages(pageable);
            model.addAttribute("clientList", clientAccounts.getContent());
        }catch (Exception e){
            System.out.println("ClientDbViewControler - KLAIDA");
        }
        return "dbview";   // kelias iki failo

    }

}
