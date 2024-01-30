package lt.daujotas.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lt.daujotas.Users.clientData.ClientData;
import lt.daujotas.validation.PhoneNumber;
import lt.daujotas.validation.PhoneNumberType;

import java.sql.Date;
import java.util.UUID;

@Table(name = "cleintdto")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor

public class ClientDto {
    private UUID accountUuid;
    private String userName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String postAddres;
    private String phoneNumber;
    private String emailAddress;
    private Date dateofbirth;



}


