package lt.daujotas.Users.Controlers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import lt.daujotas.Users.dto.UserDto;
import lt.daujotas.Users.repository.UserGeneralLoginCredentialsDataRepository;
import lt.daujotas.Users.services.UserGeneralLoginCredentialsDataService;
import lt.daujotas.dao.UserFirstRegistrationRepository;
import lt.daujotas.sipher.Client;
import lt.daujotas.sipher.srvice.DecodingGenKeyService;
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

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
public class GeneralFomControler {
    private final DecodingGenKeyService decodingGenKeyService;
    private final UserGeneralLoginCredentialsDataService userGeneralLoginCredentialsDataService;
    private final UserGeneralLoginCredentialsDataRepository userGeneralLoginCredentialsDataRepository;

    @Autowired
    public GeneralFomControler(DecodingGenKeyService decodingGenKeyService, UserGeneralLoginCredentialsDataService userGeneralLoginCredentialsDataService, UserFirstRegistrationRepository userFirstRegistrationRepository, UserGeneralLoginCredentialsDataRepository userGeneralLoginCredentialsDataRepository) {
        this.decodingGenKeyService = decodingGenKeyService;
        this.userGeneralLoginCredentialsDataService = userGeneralLoginCredentialsDataService;
        this.userGeneralLoginCredentialsDataRepository = userGeneralLoginCredentialsDataRepository;

    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/usergeneralform")
    public String showUserGeneralForm(Model model, @ModelAttribute UserDto userDto,
                                      @PageableDefault(size = 25) Pageable pageable){
        List<UserDto> userDtoList = decodingGenKeyService.getAllUsersWithDecryptedKeys(pageable);
        //zemiau esantis kodas buvo pritaikytas gauti visiems duomenims is DB pirmineje stadijoje
//           final Page<UserGeneralLoginCredentialsData> userGeneralLoginCredentialsData =
//                userGeneralLoginCredentialsDataService.getAllClientsPages(userDto, pageable);
//        model.addAttribute("userGeneralList", userGeneralLoginCredentialsData);
        model.addAttribute("userDtoList", userDtoList);
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
        return "redirect:/usergeneralform";

    }

    @Transactional
    @GetMapping("/usergeneralform/{id}/delete")
    public String deleteClient(@PathVariable UUID id) {
        userGeneralLoginCredentialsDataService.deleteUserGeneralDataByUUID(id);
        return "redirect:/usergeneralform";
    }




}


