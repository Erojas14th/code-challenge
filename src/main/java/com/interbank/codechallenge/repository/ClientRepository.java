package com.interbank.codechallenge.repository;

import com.interbank.codechallenge.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Erojas
 * <ul>
 * <li> dateCreation : 21/12/2022 22 </li>
 * <li> fileName : ClientRepository.java </li>
 * <li> description : Client repository</li>
 * </ul>
 */
@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

    void deleteByDocumentNumber(String documentNumber);

    ClientEntity findByDocumentNumber(String documentNumber);
}
