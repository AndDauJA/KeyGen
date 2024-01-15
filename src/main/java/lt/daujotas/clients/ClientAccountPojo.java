package lt.daujotas.clients;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "clientaccount")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor


public class ClientAccountPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="firstName", length = 50, nullable = false)
    private String firstName;
    @Column(length = 30, nullable = false)
    private String lastName;
    @Column(length = 50, nullable = false)
    private long phoneNumber;
    @Column(length = 250, nullable = false)
    private String emailAddress;
    @Column(columnDefinition = "BINARY(16)")
    private UUID uuid;


}

