package com.interbank.codechallenge.entity;

import javax.persistence.*;
import lombok.Data;

/**
 * @author : Erojas
 * <ul>
 * <li> dateCreation : 21/12/2022 22 </li>
 * <li> fileName : ClientEntity.java </li>
 * <li> description : Client entity</li>
 * </ul>
 */
@Data
@Entity
@Table(name = "CLIENTS")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String documentType;
    private String documentNumber;
}
