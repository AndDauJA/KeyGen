//package lt.daujotas.controlers;
//
//import lt.daujotas.clients.ClientAccountInfo;
//import lt.daujotas.service.ClientAccountService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.Optional;
//import java.util.UUID;
//
//@Controller
//public class GetDataFromDataBaseControler {
//private ClientAccountService clientAccountService;
//    @GetMapping("/clientdata/{id}")
//    public String getClientData(@PathVariable UUID id, Model model) {
//        // Retrieve the client data from the database using the id parameter
//        Optional<ClientAccountInfo> clientAccountInfo = clientAccountService.getClientByUUID(id);
//
//        // Check if the client data exists
//        if (clientAccountInfo.isPresent()) {
//            // Pass the client data to the model
//            model.addAttribute("clientAccountInfo", clientAccountInfo.get());
//        }
//
//        return "brigama/clientaccountform"; // Return the form with the populated data
//    }
//
//
//}
