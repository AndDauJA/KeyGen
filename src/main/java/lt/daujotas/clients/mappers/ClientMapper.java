package lt.daujotas.clients.mappers;

import lt.daujotas.Users.clientDataPojo.ClientData;
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

    @Override
    public ClientData fromDto(ClientDto clientDto) {
        return null;
    }


    public void fromDto(ClientDto clientDto, ClientData clientData) {
        clientData.setFirstName(clientDto.getFirstName());
        clientData.setLastName(clientDto.getLastName());
        clientData.setMiddleName(clientDto.getMiddleName());
        clientData.setPostAddres(clientDto.getPostAddres());
        clientData.setPhoneNumber(clientDto.getPhoneNumber());
        clientData.setEmailAddress(clientDto.getEmailAddress());
        // Set other fields accordingly
    }


}
