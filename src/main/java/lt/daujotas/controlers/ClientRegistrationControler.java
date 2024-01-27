package lt.daujotas.controlers;


import jakarta.validation.Valid;
import lt.daujotas.Users.dto.ClientDto;
import lt.daujotas.clients.ClientAccountInfo;
import lt.daujotas.service.ClientAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class ClientRegistrationControler {

    @Autowired
    private ClientAccountService clientAccountService;

    @GetMapping("/registrationform")
    public String showLoginForm(Model model) {
        model.addAttribute("clientAccountInfo", new ClientAccountInfo());
        return "findandupdateregistrationform"; // kelias iki failo
    }

    @PostMapping("/registrationform")
    public String createLoginClient(Model model, @Valid ClientDto clientDto, BindingResult errors) {

        if(errors.hasErrors()){

            return "findandupdateregistrationform";
        }

        clientAccountService.saveClientDto(clientDto);

        return "redirect:/client/clientTestWeb";

    }
}
