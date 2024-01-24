package lt.daujotas.clients;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accountwithlogin")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class ClientLoginToAccountconnectionInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long accountId;
}
