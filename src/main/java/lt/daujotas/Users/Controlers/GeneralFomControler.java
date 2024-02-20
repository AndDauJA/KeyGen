package lt.daujotas.Users.Controlers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import lt.daujotas.Users.dto.UserDto;
import lt.daujotas.Users.services.UserGeneralLoginCredentialsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String ShowUserGeneralForm(Model model, @ModelAttribute UserDto userDto, @PageableDefault(size = 25) Pageable pageable) {

        final Page<UserGeneralLoginCredentialsData> userGeneralLoginCredentialsData =
                userGeneralLoginCredentialsDataService.getAllClientsPages(userDto, pageable);
//        Optional<UserDto> userByUuid=userGeneralLoginSerive.getClientByUUID(userDto.getUuid());

        model.addAttribute("userGeneralList", userGeneralLoginCredentialsData);
        model.addAttribute("userDto", UserDto.builder().build());
        return "brigama/usergeneralform";
    }


    @PostMapping("/usergeneralform")
    public String registerNewUser(Model model, @Valid UserDto userDto, BindingResult errors) {

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
}
