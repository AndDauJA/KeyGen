package lt.daujotas.Users.Controlers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import lt.daujotas.Users.dto.UserDto;
import lt.daujotas.Users.services.UserGeneralLoginCredentialsDataService;
import lt.daujotas.sipher.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;



@Controller
public class GeneralFomControler {
    private final UserGeneralLoginCredentialsDataService userGeneralLoginCredentialsDataService;


    @Autowired
    public GeneralFomControler(UserGeneralLoginCredentialsDataService userGeneralLoginCredentialsDataService) {
        this.userGeneralLoginCredentialsDataService = userGeneralLoginCredentialsDataService;
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/usergeneralform")
    public String showUserGeneralForm(Model model, @ModelAttribute UserDto userDto,
                                      @PageableDefault(size = 25) Pageable pageable,
                                       String secretKey, String IV) {
        final Page<UserGeneralLoginCredentialsData> userGeneralLoginCredentialsData =
                userGeneralLoginCredentialsDataService.getAllClientsPages(userDto, pageable);
//        userGeneralLoginCredentialsData.forEach(data -> {
//            try {
//                String decryptedKey = userGeneralLoginCredentialsDataService.decryptPassword(
//                        data.getGeneratedkey(), "38oskpgEmTOZCHlmjpFnqg==", "124M+To7dHTo4moD8uh/xg==");
//                data.setGeneratedkey(decryptedKey);
//            } catch (Exception e) {
//                // Handle decryption error
//                e.printStackTrace();
//            }
//        });


        model.addAttribute("userGeneralList", userGeneralLoginCredentialsData);
        model.addAttribute("userDto", UserDto.builder().build());
        return "brigama/usergeneralform";
    }


    @PostMapping("/usergeneralform")
    public String registerNewUser(Model model, @Valid UserDto userDto, BindingResult errors) throws Exception {

        if (errors.hasErrors()) {
            return "brigama/usergeneralform";
        }
        userGeneralLoginCredentialsDataService.inputKeyGenData(userDto);
        // TODO pabaigti kad mestu message
        return "brigama/usergeneralform";

    }

    @Transactional
    @GetMapping("/usergeneralform/{id}/delete")
    public String deleteClient(@PathVariable UUID id) {
        userGeneralLoginCredentialsDataService.deleteUserGeneralDataByUUID(id);
        return "redirect:/usergeneralform";
    }
//    @GetMapping("/decryptPassword")
//    public ResponseEntity<String> decryptPassword(@RequestParam String encryptedPassword, @RequestParam String secretKey, @RequestParam String IV) {
//        try {
//            String decryptedPassword = userGeneralLoginCredentialsDataService.decryptPassword(encryptedPassword, secretKey, IV);
//            return ResponseEntity.ok(decryptedPassword);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error decrypting password");
//        }
//    }
}
