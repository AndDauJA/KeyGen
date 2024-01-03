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
    //    @Column(name="first_Name")
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String emailAddress;




}

