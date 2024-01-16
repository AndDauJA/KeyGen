package lt.daujotas.controlers;

import lombok.AllArgsConstructor;
import lt.daujotas.clients.ClientAccountPojo;
import lt.daujotas.service.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@AllArgsConstructor
@RequestMapping("/create")
public class ClientAddToDBControler {

//
//    @Autowired
//    private ClientAccountService clientAccountService;
//
//    @GetMapping("/clientTestWeb")
//    public String ClientTestWebControler(Model model) {
//        model.addAttribute("createClientAccount", new ClientAccountPojo());
//        return "clientTestWeb"; //nurodom kontroleri^
//    }
//
//    @PostMapping("/clientForm")
//    public String createClient(ClientAccountPojo clientAccountPojo) {
//        clientAccountService.saveClient(clientAccountPojo);
//
//        return "redirect:/client/clientTestWeb";
//
//    }
}
