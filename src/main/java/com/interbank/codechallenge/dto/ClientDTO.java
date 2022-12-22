package com.interbank.codechallenge.dto;

import lombok.Data;

/**
 * @author : Erojas
 * <ul>
 * <li> dateCreation : 21/12/2022 22 </li>
 * <li> fileName : ClientDTO.java </li>
 * <li> description : Client DTO</li>
 * </ul>
 */
@Data
public class ClientDTO {

    private String clientId;
    private String firstName;
    private String lastName;
    private String documentType;
    private String documentNumber;
}
