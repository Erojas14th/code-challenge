package com.interbank.codechallenge.controller;

import com.interbank.codechallenge.client.api.*;
import com.interbank.codechallenge.client.model.Client;
import com.interbank.codechallenge.services.IClientApi;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author : Erojas
 * <ul>
 * <li> dateCreation : 21/12/2022 23 </li>
 * <li> fileName : ClientController.java </li>
 * <li> description : </li>
 * </ul>
 */
@RequestMapping(value = "/clients")
@RestController
public class ClientController implements FindAllApi, FindOneApi, SaveApi, DeleteApi, UpdateApi {

    private final IClientApi clientApi;

    @Autowired
    public ClientController(IClientApi clientApi) {
        this.clientApi = clientApi;
    }

    /**
     * GET /findAll
     * Find all clients information
     *
     * @return OK (status code 200)
     * or BAD REQUEST (status code 400)
     * or NOT FOUND (status code 404)
     * or INTERNAL SERVER ERROR (status code 500)
     */
    @Override
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(clientApi.findAll());
    }

    /**
     * GET /findOne
     * Find one client information
     *
     * @param codigoUnico ID client (required)
     * @return OK (status code 200)
     * or BAD REQUEST (status code 400)
     * or NOT FOUND (status code 404)
     * or INTERNAL SERVER ERROR (status code 500)
     */
    @Override
    public ResponseEntity<Client> findOne(String codigoUnico) {
        Optional<Client> result = clientApi.findOne(codigoUnico);
        if (Boolean.TRUE.equals(result.isPresent())) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * POST /save
     * Save a client information
     *
     * @param client Body client information (required)
     * @return Save OK (status code 200)
     */
    @Override
    public ResponseEntity<Client> save(@RequestBody Client client) {
        Optional<Client> result = clientApi.save(client);
        if (Boolean.TRUE.equals(result.isPresent())) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.noContent().build();
        }
    }


    @Override
    public ResponseEntity<Void> update(Client client) {
        clientApi.update(client);
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(String codigoUnico) {
        if (StringUtils.isBlank(codigoUnico)) {
            return ResponseEntity.badRequest().build();
        } else {
            clientApi.delete(codigoUnico);
        }

        return null;
    }
}
