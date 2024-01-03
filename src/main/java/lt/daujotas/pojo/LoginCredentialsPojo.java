package lt.daujotas.pojo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "loginCredentials")
@Getter
@Setter
@NoArgsConstructor


public class LoginCredentialsPojo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String generatedKey;
    private String webBrowser;
    private String webAddress;
    @Column(name="user_name")
    private String userName;


}
