package lt.daujotas.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lt.daujotas.validation.PhoneNumber;
import lt.daujotas.validation.PhoneNumberType;
import lt.daujotas.validation.RepeatPassword;
import org.springframework.format.annotation.DateTimeFormat;

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
    @NotEmpty( message= "{NotEmpty.Name.message.userName} ")
    private String userName;
    @NotEmpty(message = "{NotEmpty.Name.message.Name}")
    private String firstName;
    private String middleName;
    @NotEmpty(message = "{NotEmpty.Name.message.lastName}")
    private String lastName;

    private String postAddres;
    @NotEmpty(message = "{NotEmpty.Name.message.phone}")
    @PhoneNumber(numberType = PhoneNumberType.GLOBAL)
    private String phoneNumber;
    @NotEmpty(message = "{NotEmpty.Name.message.email}")
    @Column(name = "emailaddress", unique = true)
    private String emailAddress;
    @Column(name = "dateofbirth" )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;
    @NotEmpty(message = "{NotEmpty.Name.message.password}")
    private String password;
    private String repeatPassword;
    private String gender;




}


