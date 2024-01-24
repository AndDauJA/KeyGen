package lt.daujotas.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lt.daujotas.clients.ClientAccountInfo;
import lt.daujotas.clients.ClientLoginInfo;
import lt.daujotas.clients.repositories.ClientRepository;
import lt.daujotas.clients.repositories.FindClientByNameRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ClientJPADao implements ClientDao {
    @Autowired
    ClientRepository repository;
    @Autowired
    FindClientByNameRepository findClientByNameRepository;
    @Autowired
    private EntityManager entityManager;

    @Override
    public void save(ClientAccountInfo clientAccountInfo) {
        clientAccountInfo.setAccountUuid(UUID.randomUUID());
        repository.save(clientAccountInfo);
    }

    @Override
    public void merge(ClientAccountInfo clientAccountInfo) {
        repository.save(clientAccountInfo);
    }


    @Override
    public void update(ClientAccountInfo updatedClient) {
        findClientByNameRepository.save(updatedClient);
    }

    @Override
    public List<ClientAccountInfo> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<ClientAccountInfo> getClientByUUID(UUID id) {
        return repository.findByAccountUuid(id);
    }

    @Override
    public Optional<ClientAccountInfo> getClientByFirstName(String firstName) {
        return findClientByNameRepository.findByFirstName(firstName);
    }

    @Override
    public void deleteClientByUUID(UUID id) {
        Optional<ClientAccountInfo> client = repository.findByAccountUuid(id);
        client.ifPresent(repository::delete);

        }

    @Override
    public Page<ClientAccountInfo> getPage(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<ClientAccountInfo> getClientByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<ClientLoginInfo> findByUsername(String username) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ClientLoginInfo> query = criteriaBuilder.createQuery(ClientLoginInfo.class);
        Root<ClientLoginInfo> root = query.from(ClientLoginInfo.class);

        query.select(root)
                .where(criteriaBuilder.equal(root.get("username"), username));

        List<ClientLoginInfo> resultList = entityManager.createQuery(query).getResultList();
        return resultList.isEmpty() ? Optional.empty() : Optional.of(resultList.get(0));
    }


}


