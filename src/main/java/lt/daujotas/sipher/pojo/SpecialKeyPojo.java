package lt.daujotas.sipher.pojo;

import jakarta.persistence.*;
import lombok.*;
import lt.daujotas.Users.clientDataPojo.UserGeneralLoginCredentialsData;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpecialKeyPojo {

    @Id
    private UUID specKeyId;
    String secretKey;
    @OneToOne
    @JoinColumn(name = "userGeneralLoginCredentialsDataId")
    private UserGeneralLoginCredentialsData userGeneralLoginCredentialsData;

}
