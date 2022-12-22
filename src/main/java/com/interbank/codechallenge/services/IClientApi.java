package com.interbank.codechallenge.services;

import com.interbank.codechallenge.client.model.Client;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author : Erojas
 * <ul>
 * <li> dateCreation : 21/12/2022 23 </li>
 * <li> fileName : IClientApi.java </li>
 * <li> description : </li>
 * </ul>
 */
@Transactional
public interface IClientApi {

    /**
     * Delete a client
     *
     * @param codigoUnico ID client
     */
    public void delete(String codigoUnico);

    /**
     * Find all clients information
     *
     * @return List<Client>
     */
    public List<Client> findAll();

    /**
     * Find one client information
     *
     * @param codigoUnico ID client
     * @return Optional<Client>
     */
    public Optional<Client> findOne(String codigoUnico);

    /**
     * Save a client information
     *
     * @param client api
     * @return Optional<ClientDTO>
     */
    public Optional<Client> save(Client client);

    /**
     * Update a client information
     *
     * @param client api
     */
    public void update(Client client);
}
