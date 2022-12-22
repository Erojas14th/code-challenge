package com.interbank.codechallenge.services;

import com.interbank.codechallenge.client.model.Client;
import com.interbank.codechallenge.entity.ClientEntity;
import com.interbank.codechallenge.mapper.IClientMapper;
import com.interbank.codechallenge.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : Erojas
 * <ul>
 * <li> dateCreation : 21/12/2022 22 </li>
 * <li> fileName : ClientRepository.java </li>
 * <li> description : Repository client</li>
 * </ul>
 */
@Slf4j
@Service
public class ClientApi implements IClientApi {

    private final ClientRepository clientRepository;
    private final IClientMapper clientMapper;

    @Autowired
    public ClientApi(ClientRepository clientRepository, IClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    /**
     * Delete a client
     *
     * @param codigoUnico ID client
     */
    @Override
    public void delete(String codigoUnico) {
        Optional.ofNullable(codigoUnico)
                .ifPresent(clientRepository::deleteByDocumentNumber);
    }

    /**
     * Find all clients information
     *
     * @return List<Client>
     */
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(clientMapper::entityToDto)
                .map(clientMapper::dtoToApi)
                .collect(Collectors.toList());
    }

    /**
     * Find one client information
     *
     * @param codigoUnico ID client
     * @return Client
     */
    @Override
    public Optional<Client> findOne(String codigoUnico) {
        return Optional.ofNullable(codigoUnico)
                .map(clientRepository::findByDocumentNumber)
                .map(clientMapper::entityToDto)
                .map(clientMapper::dtoToApi);
    }

    /**
     * Save a client information
     *
     * @param client api
     * @return Client
     */
    @Override
    public Optional<Client> save(Client client) {
        return Optional.ofNullable(client)
                .map(clientMapper::apiToDto)
                .map(clientMapper::dtoToEntity)
                .map(clientRepository::save)
                .map(clientMapper::entityToDto)
                .map(clientMapper::dtoToApi);
    }

    /**
     * Update a client information
     *
     * @param client api
     */
    @Override
    public void update(Client client) {
        Optional.ofNullable(client.getNumeroDocumento())
                .map(clientRepository::findByDocumentNumber)
                .map(i -> updateValues(i, client))
                .map(clientRepository::save)
                .ifPresent(i -> log.info("Update successfully for clientId = {}", i.getId()));
    }

    /**
     * Update values
     *
     * @param entity entity
     * @param api    api
     * @return ClientEntity
     */
    private ClientEntity updateValues(ClientEntity entity, Client api) {
        entity.setDocumentNumber(api.getNumeroDocumento());
        entity.setDocumentType(api.getTipoDocumento());
        entity.setFirstName(api.getNombres());
        entity.setLastName(api.getApellidos());
        return entity;
    }
}
