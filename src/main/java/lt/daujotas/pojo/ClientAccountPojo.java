package lt.daujotas.pojo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clientaccount")
@Getter
@Setter
@NoArgsConstructor


public class ClientAccountPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 50, nullable = false)
    private String firstName;
    @Column(length = 30, nullable = false)
    private String lastName;
    @Column(length = 20, nullable = false)
    private long phoneNumber;
    @Column(length = 250, nullable = false)
    private String emailAddress;




}

