package lt.daujotas.clients;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usedlogins")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class UsedLoginCredentialsInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50, nullable = false)
    private String generatedkey;
    @Column(length = 50, nullable = false)
    private String webbrowser;
    @Column(length = 255, nullable = true)
    private String webaddress;
    @Column(length = 150, nullable = true)
    private String username;


}
