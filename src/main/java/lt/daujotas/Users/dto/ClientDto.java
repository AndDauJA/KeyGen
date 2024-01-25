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
import org.hibernate.validator.constraints.UUID;

import java.sql.Date;

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

    @NotEmpty
    @Column(name = "username")
    private String userName;
    @NotEmpty
    @Column(name = "firstname")
    private String firstName;
    @NotEmpty
    @Column(name = "middlename")
    private String middleName;
    @NotEmpty
    @Column(name = "lastname")
    private String lastName;
    @NotEmpty
    @Column(name = "postaddress")
    private String postAddres;
    @NotEmpty
    @Column(name = "phonenumber")
    @PhoneNumber(numberType = PhoneNumberType.GLOBAL)
    private String phoneNumber;
    @NotEmpty
    private String password;
    @NotEmpty
    @Column(name = "repeatpassword")
    private String repeatPassrowd;

    @NotEmpty(message = "{NotEmpty.Name.message.email}")
    @Column(name = "emailaddress")
    private String emailAddress;

    @Column(name = "dateofbirth")
    @Temporal(TemporalType.DATE)
    private Date dateofbirth;
    private String gender;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ClientAccountInfo clientAccountInfo;

}
