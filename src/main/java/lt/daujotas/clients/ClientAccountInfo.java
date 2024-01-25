package lt.daujotas.clients;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import lombok.*;

import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name = "clientaccount")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class ClientAccountInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(columnDefinition = "BINARY(16)", name = "uuid")
    private UUID accountUuid;

    @Column(length = 50, nullable = false)
    @NotEmpty(message = "{NotEmpty.Name.message.Name}")
    private String firstName;

    @Column(length = 30, nullable = true)
    private String middleName;

    @Column(length = 30, nullable = false)
    @NotEmpty(message = "{NotEmpty.Name.message.lastName}")
    private String lastName;
    @Column(length = 250, nullable = true)
    private String postAddres;
    @Column(length = 50, nullable = false)
    @NotEmpty(message = "{NotEmpty.Name.message.phone}")
    private String phoneNumber;
    @Column(length = 250, nullable = false)
    @NotEmpty(message = "{NotEmpty.Name.message.email}")
    private String emailAddress;

    @Column(name = "dateofbirth")
    @Temporal(TemporalType.DATE)
       private Date dateofbirth;

    @Column(length = 10, nullable = true)
    private String gender;

    @OneToOne(mappedBy = "clientAccountInfo")
    @JoinColumn(name = "Id")
    private ClientLoginInfo loginInfo;

}

