package lt.daujotas.Users.dao;

import lt.daujotas.clients.ClientLoginInfo;

public interface UserDao {
    void save (ClientLoginInfo clientLoginInfo);
}
