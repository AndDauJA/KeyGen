package lt.daujotas.Users.clientDataPojo;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;

@Builder
@Setter

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Authority implements GrantedAuthority {

    @Serial
    private static final long serialVersionUID = -2759184906241814492L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Column(name = "name")
    private String name;
    private String description;

    @Override
    public String getAuthority() {
        return "ROLE_"+name;
    }   // butinai reikia ROLE_ prieraso kad veiktu roles

}
