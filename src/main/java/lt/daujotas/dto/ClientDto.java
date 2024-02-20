package lt.daujotas.dto;

import jakarta.persistence.*;
import lombok.*;
import lt.daujotas.validation.RepeatPassword;

import java.sql.Date;
import java.util.UUID;

@Table(name = "cleintdto")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
@RepeatPassword
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
    private String password;
    private String repeatPassword;
    private String gender;




}


