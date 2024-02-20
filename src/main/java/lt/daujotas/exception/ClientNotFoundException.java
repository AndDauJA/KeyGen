package lt.daujotas.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
@RequiredArgsConstructor
@Getter
public class ClientNotFoundException extends RuntimeException {
    private final UUID clientUUID;
//    private final String userName;

    @Override
    public String getMessage() {
        return "Client not found with UUID: " + clientUUID;
        }


}
