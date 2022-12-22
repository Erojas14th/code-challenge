package com.interbank.codechallenge.mapper;

import com.interbank.codechallenge.client.model.Client;
import com.interbank.codechallenge.dto.ClientDTO;
import com.interbank.codechallenge.entity.ClientEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/**
 * @author : Erojas
 * <ul>
 * <li> dateCreation : 21/12/2022 22 </li>
 * <li> fileName : ClientMapper.java </li>
 * <li> description : Client dto, entity and api mapper</li>
 * </ul>
 */
@Mapper
public interface IClientMapper {

    @Mapping(source = "id", target = "clientId")
    ClientDTO entityToDto(ClientEntity entity);

    ClientEntity dtoToEntity(ClientDTO dto);

    @Mappings({
            @Mapping(source = "firstName", target = "nombres"),
            @Mapping(source = "lastName", target = "apellidos"),
            @Mapping(source = "documentType", target = "tipoDocumento"),
            @Mapping(source = "documentNumber", target = "numeroDocumento")
    })
    Client dtoToApi(ClientDTO dto);

    @Mappings({
            @Mapping(source = "nombres", target = "firstName"),
            @Mapping(source = "apellidos", target = "lastName"),
            @Mapping(source = "tipoDocumento", target = "documentType"),
            @Mapping(source = "numeroDocumento", target = "documentNumber")
    })
    ClientDTO apiToDto(Client client);

}
