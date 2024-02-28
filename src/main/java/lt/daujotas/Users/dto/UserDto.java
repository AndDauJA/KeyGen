package lt.daujotas.Users.dto;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
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
    @NotEmpty( message= "{NotEmpty.Name.message.userNames} ")
    private String userNameEmail;
    @NotEmpty(message = "NotEmpty.Name.message.genkey")
    private String generatedkey;
    @NotEmpty(message = "{NotEmpty.Name.message.webaddress}")
    private String webaddress;
    private String notes;
    private Date dateAdded;
    private String decryptedKey;
}
