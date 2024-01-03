package lt.daujotas.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class LoginCredentialsPojo {

private int id;
private String generatedKey;
private String webBrowser;
private String webAddress;
private String userName;


}
