package lt.daujotas.Users.services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;
import lt.daujotas.Users.dto.UserDto;
import lt.daujotas.Users.repository.UserGeneralLoginCredentialsDataRepository;
import lt.daujotas.clientPojo.ClientData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserGeneralLoginCredentialsDataService {
    private final UserGeneralLoginCredentialsDataRepository userGeneralLoginCredentialsDataRepository;

    public void inputKeyGenData(UserDto userDto) {
//        String encodedPassword = new BCryptPasswordEncoder().encode(userDto.getGeneratedkey());
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final ClientData clientData = (ClientData) authentication.getPrincipal();
        userGeneralLoginCredentialsDataRepository.save(
                UserGeneralLoginCredentialsData.builder()
                        .username(userDto.getUserNameEmail())
                        .generatedkey(userDto.getGeneratedkey())
                        .uuid(UUID.randomUUID())
                        .webaddress(userDto.getWebaddress())
                        .notes(userDto.getNotes())
                        .clientDataId(clientData.getId())
                        .build()
        );


    }
    @Transactional
    public void deleteUserGeneralDataByUUID(UUID credentialDataId) {
        userGeneralLoginCredentialsDataRepository.deleteById(credentialDataId);
    }



    public Page<UserGeneralLoginCredentialsData> getAllClientsPages(UserDto userDto, Pageable pageable) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final ClientData clientData = (ClientData) authentication.getPrincipal();
        return userGeneralLoginCredentialsDataRepository.findByClientDataId(clientData.getId(), pageable);
    }
  }
