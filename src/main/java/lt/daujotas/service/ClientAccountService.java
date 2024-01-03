package lt.daujotas.service;

import lombok.RequiredArgsConstructor;
import lt.daujotas.dao.ClientAccountDao;
import lt.daujotas.exception.DataNotFoundException;
import lt.daujotas.pojo.ClientAccountPojo;

import java.util.List;

@RequiredArgsConstructor


public class ClientAccountService {

    private final ClientAccountDao clientAccountDao;
//get data all  bet turi buti cia DOmenas

    public List<ClientAccountPojo> getAll(){

        return clientAccountDao.getAll();

    }public ClientAccountPojo getById(Long id){

       return clientAccountDao
               .getOneById(id)
               .orElseThrow(DataNotFoundException::new);

    }

}
