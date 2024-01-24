package lt.daujotas.dto;



import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.validator.constraints.UUID;

import java.sql.Date;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ClientDto {
    private UUID clientUuid;
    @NotNull (message= "Negali buti tuscia eilute ${ValidatedValue}")
    private String firstName;
    private String middleName;
    private String lastName;
    private String postAddres;
    private String phoneNumber;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}$", message = "Neteisingas elektroninio pašto adresas")
    private String emailAddress;
    private Date dateofbirth;
    private String gender;

}
