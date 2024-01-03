package lt.daujotas.pojo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "loginCredentials")
@Getter
@Setter
@NoArgsConstructor
@ToString


public class LoginCredentialsPojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50, nullable = false)
    private String generatedKey;
    @Column(length = 50, nullable = false)
    private String webBrowser;
    @Column(length = 255, nullable = true)
    private String webAddress;
    @Column(name="user_name", length = 150, nullable = true)
    private String userName;


}
