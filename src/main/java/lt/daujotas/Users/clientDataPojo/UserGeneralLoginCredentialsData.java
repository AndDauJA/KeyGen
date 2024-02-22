package lt.daujotas.Users.clientDataPojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lt.daujotas.Users.utils.UserGeneralLoginCredentialsInfoListener;
import lt.daujotas.clientPojo.ClientData;
import lt.daujotas.sipher.pojo.IVKeyPojo;
import lt.daujotas.sipher.pojo.SpecialKeyPojo;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "usedlogins")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
@EntityListeners(UserGeneralLoginCredentialsInfoListener.class)
public class UserGeneralLoginCredentialsData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid;
    @NotEmpty(message = "{NotEmpty.Name.message.genkey}")
    @Column(nullable = false)
    private String generatedkey;
    @Column(length = 50, nullable = true)
    private String webbrowser;
    @Column(length = 255, nullable = true)
    private String webaddress;
    @Column(length = 150, nullable = true)
    private String username;
    private String notes;
    private Date dateAdded;
    private Long clientDataId;


    @OneToOne(mappedBy = "userGeneralLoginCredentialsData", cascade = CascadeType.ALL)
    private SpecialKeyPojo specKeyId;

    @OneToOne(mappedBy = "userGeneralLoginCredentialsData", cascade = CascadeType.ALL)
    private IVKeyPojo IVKeyId;


}
