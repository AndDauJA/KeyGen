package lt.daujotas.clients.mappers;

import lt.daujotas.clientPojo.ClientData;
import lt.daujotas.dto.ClientDto;
import lt.daujotas.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper implements Mapper<ClientData, ClientDto> {


    public ClientDto toDto(ClientData entity) {
        return ClientDto.builder()
                .userName(entity.getUserName())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .middleName(entity.getMiddleName())
                .postAddres(entity.getPostAddres())
                .phoneNumber(entity.getPhoneNumber())
                .emailAddress(entity.getEmailAddress())
                .build();
    }




    public ClientData fromDto(ClientDto clientDto) {

        return ClientData.builder()
                .firstName(clientDto.getFirstName())
                .lastName(clientDto.getLastName())
                .middleName(clientDto.getMiddleName())
                .accountUuid(clientDto.getAccountUuid())
                .userName(clientDto.getUserName())
                .gender(clientDto.getGender())
                .emailAddress(clientDto.getEmailAddress())
                .phoneNumber(clientDto.getPhoneNumber())
                .dateofbirth(clientDto.getDateofbirth())
                .postAddres(clientDto.getPostAddres())

                .build();
    }


}
