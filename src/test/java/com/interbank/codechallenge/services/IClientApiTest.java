package com.interbank.codechallenge.services;

import com.interbank.codechallenge.client.model.Client;
import com.interbank.codechallenge.entity.ClientEntity;
import com.interbank.codechallenge.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author : Erojas
 * <ul>
 * <li> dateCreation : 21/12/2022 22 </li>
 * <li> fileName : IClientApiTest.java </li>
 * <li> description : </li>
 * </ul>
 */
@SpringBootTest
class IClientApiTest {

    private final IClientApi clientApi;
    private final ClientRepository repository;
    private final String CODIGO_UNICO = "7654321";
    private final String CODIGO_UNICO_2 = "12345678";

    @Autowired
    public IClientApiTest(ClientRepository repository, IClientApi clientApi) {
        this.repository = repository;
        this.clientApi = clientApi;
    }

    @BeforeEach
    public void setUp() {
        ClientEntity client = this.getEntity(CODIGO_UNICO);

        repository.deleteAll();
        repository.save(client);
    }

    @Test
    @DisplayName("Delete")
    void delete() {
        assertEquals(1, repository.count());
        clientApi.delete(CODIGO_UNICO);
        assertEquals(0, repository.count());
    }

    @Test
    @DisplayName("findAll")
    void findAll() {
        assertEquals(1, repository.count());
        assertEquals(1, clientApi.findAll().size());
    }

    @Test
    @DisplayName("findOne")
    void findOne() {
        assertEquals(1, repository.count());
        Optional<Client> client = clientApi.findOne(CODIGO_UNICO);
        assertTrue(client.isPresent());
        assertEquals(CODIGO_UNICO, client.get().getNumeroDocumento());
    }

    @Test
    @DisplayName("save")
    void save() {
        assertEquals(1, repository.count());
        Client client = this.getApi("Juan", CODIGO_UNICO_2);
        Optional<Client> newClient = clientApi.save(client);
        assertTrue(newClient.isPresent());
        assertEquals(CODIGO_UNICO_2, newClient.get().getNumeroDocumento());
        assertEquals(2, repository.count());
    }

    @DisplayName("update")
    void update() {
        Client client = this.getApi("PEPE", CODIGO_UNICO);
        clientApi.update(client);
        assertEquals("PEPE", client.getNombres());
    }

    /**
     * Entity item
     *
     * @param id Codigo unico
     * @return ClientEntity
     */
    public ClientEntity getEntity(String id) {
        ClientEntity client = new ClientEntity();
        client.setFirstName("Juan");
        client.setLastName("Soto Rivera");
        client.setDocumentType("DNI");
        client.setDocumentNumber(id);
        return client;
    }

    /**
     * Api item
     *
     * @param id Codigo unico
     * @return Client
     */
    public Client getApi(String name, String id) {
        Client client = new Client();
        client.setNombres(name);
        client.setApellidos("Soto Rivera");
        client.setTipoDocumento("DNI");
        client.setNumeroDocumento(id);
        return client;
    }
}
