package lt.daujotas.clients;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "logintoaccount")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class ClientLoginInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long accountId;
    @Column(length = 50, nullable = false)
    private String username;
    @Column(length = 30, nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ClientAccountInfo clientAccountInfo;

}

