package lt.daujotas.clients;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lt.daujotas.Users.dto.ClientDto;


@Table(name = "logintoaccount")
@Getter
@Setter
@NoArgsConstructor
@ToString
@Builder
@AllArgsConstructor
public class ClientLoginInfo {




    @NotEmpty(message = "{NotEmpty.Name.message.username}")
    private String username;
    @NotEmpty(message = "{NotEmpty.Name.message.password}")
    private String password;





}

