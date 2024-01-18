package lt.daujotas.controlers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
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
