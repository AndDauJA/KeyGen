package lt.daujotas.Users.dto;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lt.daujotas.clients.ClientAccountInfo;
import lt.daujotas.clients.ClientLoginInfo;
import lt.daujotas.validation.PhoneNumber;
import lt.daujotas.validation.PhoneNumberType;
import lt.daujotas.validation.RepeatPassword;

import java.sql.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@Table(name = "clientaccountDto")
@Builder
@Getter
@Setter
@NoArgsConstructor
@ToString
@RepeatPassword
public class ClientDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty (message = "{NotEmpty.Name.message.userName}")
    @Column(name = "username")
    private String userName;
    @NotEmpty(message = "{NotEmpty.Name.message.Name}")
    @Column(name = "firstname")
    private String firstName;

    @Column(name = "middlename")
    private String middleName;
    @NotEmpty (message = "{NotEmpty.Name.message.lastName}")
    @Column(name = "lastname")
    private String lastName;
    @NotEmpty (message = "{NotEmpty.Name.message.postAddress}")
    @Column(name = "postaddress")
    private String postAddres;
    @NotEmpty (message = "{NotEmpty.Name.message.phone}")
    @Column(name = "phonenumber")
    @PhoneNumber(numberType = PhoneNumberType.GLOBAL)
    private String phoneNumber;
    @NotEmpty
    @NotEmpty(message = "{NotEmpty.Name.message.password}")
    private String password;

    @Column(name = "repeatpassword")
    private String repeatPassrowd;

    @NotEmpty(message = "{NotEmpty.Name.message.email}")
    @Column(name = "emailaddress")
    private String emailAddress;

    @Column(name = "dateofbirth")
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;
    private String gender;

    @Column(columnDefinition = "BINARY(16)", name = "uuid")
    private UUID accountUuid;
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ClientAccountInfo clientAccountInfo;

}
