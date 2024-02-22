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
public class IVKeyPojo {
    @Id
    private UUID IVKeyId;
    @Column(name = "IV")
    String specialIVKey;
    @OneToOne
    @JoinColumn(name = "userGeneralLoginCredentialsDataId")
    private UserGeneralLoginCredentialsData userGeneralLoginCredentialsData;
}
