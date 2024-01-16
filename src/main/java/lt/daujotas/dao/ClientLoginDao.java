package lt.daujotas.dao;

import lt.daujotas.clients.ClientAccountPojo;
import lt.daujotas.clients.ClientLoginPojo;

public interface ClientLoginDao {

    void login(ClientLoginPojo clientLoginPojo);
}
