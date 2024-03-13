package lt.daujotas.Users.Controlers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import lt.daujotas.Users.dto.UserDto;
import lt.daujotas.Users.repository.UserGeneralLoginCredentialsDataRepository;
import lt.daujotas.Users.services.UserGeneralLoginCredentialsDataService;
import lt.daujotas.clientPojo.ClientData;
import lt.daujotas.dao.ClientRepository;
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    private final ClientRepository clientRepository;

    @Autowired
    public GeneralFomControler(DecodingGenKeyService decodingGenKeyService, UserGeneralLoginCredentialsDataService userGeneralLoginCredentialsDataService, UserFirstRegistrationRepository userFirstRegistrationRepository, UserGeneralLoginCredentialsDataRepository userGeneralLoginCredentialsDataRepository, ClientRepository clientRepository) {
        this.decodingGenKeyService = decodingGenKeyService;
        this.userGeneralLoginCredentialsDataService = userGeneralLoginCredentialsDataService;
        this.userGeneralLoginCredentialsDataRepository = userGeneralLoginCredentialsDataRepository;
        this.clientRepository = clientRepository;
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/usergeneralform")
    public String showUserGeneralForm(Model model, @ModelAttribute UserDto userDto,
                                      @PageableDefault(size = 25) Pageable pageable) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Get username of the logged-in user
        ClientData clientData = clientRepository.findByUserName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        List<UserDto> userDtoList = decodingGenKeyService.hideTheGeneratedKey(clientData.getId(), pageable);

        model.addAttribute("userDtoList", userDtoList);
        model.addAttribute("userDto", UserDto.builder().build());
        return "brigama/usergeneralform";
    }

    @GetMapping("/api/decrypted-key/{uuid}")
    public ResponseEntity<?> getDecryptedKey(@PathVariable UUID uuid, Authentication authentication) {
        try {
            ClientData clientData = (ClientData) authentication.getPrincipal();
            // Čia tikrinama, ar UUID priklauso prisijungusiam vartotojui, galite pridėti šią logiką
            String decryptedKey = decodingGenKeyService.decryptMessage(uuid);
            return ResponseEntity.ok(decryptedKey);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Nepavyko dešifruoti rakto: " + e.getMessage());
        }
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
    @GetMapping("/usergeneralform/{uuid}/delete")
    public String deleteClient(@PathVariable UUID uuid) {
        userGeneralLoginCredentialsDataService.deleteUserGeneralDataByUUID(uuid);
        return "redirect:/usergeneralform";
    }


}


