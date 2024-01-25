package lt.daujotas.Users.Controlers;


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
public class UserRegistrationContrler {

    @Autowired
    private ClientAccountService clientAccountService;

    @GetMapping("/userregistrationform")
    public String showLoginForm(Model model) {
        model.addAttribute("clientDto", new ClientDto());
        return "brigama/userregistrationform"; // kelias iki failo
    }

    @PostMapping("/userregistrationform")
    public String createLoginClient(Model model, @Valid ClientDto clientDto, BindingResult errors) {

        if(errors.hasErrors()){

            return "brigama/userregistrationform";
        }

        clientAccountService.saveClientDto(clientDto);

        return "redirect:/client/clientTestWeb";

    }
}
