package lt.daujotas.controlers;


import lt.daujotas.service.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientTestWebControler {

    @Autowired
    private ClientAccountService clientAccountService;

    @GetMapping("/clientTestWeb")
    public String showTestWebForm(Model model) {
//        model.addAttribute("createClientAccount", new ClientAccountPojo());
        return "clientTestWeb"; // kelias iki failo
    }
//
//    @PostMapping("/clientForm") //post jei norime issaugoti turi buti==clientForm.html=> th:action="@{/creat/clientForm}"
//    public String createClient(@ModelAttribute ClientAccountPojo clientAccount) {
//        clientAccountService.saveClient(clientAccount);
//        System.out.println("Saved itn the DB");
//        clientAccountService.getAllClients().forEach(System.out::println); //kad matyciau kas isaugota DB
//        return "redirect:/client/clientTestWeb";
//    }
}
