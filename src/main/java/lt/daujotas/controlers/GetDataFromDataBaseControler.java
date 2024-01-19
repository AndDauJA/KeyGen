package lt.daujotas.controlers;

import lt.daujotas.clients.ClientAccountInfo;
import lt.daujotas.service.ClientAccountService;
import org.hibernate.validator.constraints.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class GetDataFromDataBaseControler {
private ClientAccountService clientAccountService;
//    @GetMapping("/clientdata/{id}")
//    public String getClientData(@PathVariable String name , Model model) {
//        // Retrieve the client data from the database using the id parameter
//        Optional<ClientAccountInfo> clientData = clientAccountService.get;
//
//        // Check if the client data exists
//        if (clientData.isPresent()) {
//            // Pass the client data to the model
//            model.addAttribute("clientData", clientData.get());
//        }
//
//        return "brigama/clientaccountform"; // Return the form with the populated data
//    }
}
