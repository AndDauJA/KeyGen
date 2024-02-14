package lt.daujotas.Users.dto;

import jakarta.persistence.Table;
import lombok.*;
import lt.daujotas.validation.RepeatPassword;


import java.util.Date;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor

public class UserDto {
    private UUID uuid;
    private String userNameEmail;
    private String generatedkey;
    private String webaddress;
    private String notes;
    private Date dateAdded;

}
