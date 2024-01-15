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

public class ClientLoginPojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50, nullable = false)
    private String UserName;
    @Column(length = 30, nullable = true)
    private String password;
}

