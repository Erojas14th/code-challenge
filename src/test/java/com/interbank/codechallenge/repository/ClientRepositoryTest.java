package com.interbank.codechallenge.repository;

import com.interbank.codechallenge.entity.ClientEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author : Erojas
 * <ul>
 * <li> dateCreation : 21/12/2022 22 </li>
 * <li> fileName : ClientRepositoryTest.java </li>
 * <li> description : </li>
 * </ul>
 */
@DataJpaTest
class ClientRepositoryTest {

    private final ClientRepository repository;

    @Autowired
    public ClientRepositoryTest(ClientRepository repository) {
        this.repository = repository;
    }

    @BeforeEach
    public void setUp() {
        ClientEntity client = new ClientEntity();
        client.setFirstName("Juan");
        client.setLastName("Soto Rivera");
        client.setDocumentType("DNI");
        client.setDocumentNumber("7654321");

        repository.deleteAll();
        repository.save(client);
    }

    @Test
    @DisplayName("deleteByDocumentNumber")
    void deleteByDocumentNumber() {
        assertEquals(1, repository.count());
        repository.deleteByDocumentNumber("7654321");
        assertEquals(0, repository.count());
    }

    @Test
    @DisplayName("findByDocumentNumber")
    void findByDocumentNumber() {
        ClientEntity entity = repository.findByDocumentNumber("7654321");
        assertEquals(entity.getDocumentNumber(), "7654321");
    }
}
