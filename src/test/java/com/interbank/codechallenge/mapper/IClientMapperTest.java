package com.interbank.codechallenge.mapper;

import com.interbank.codechallenge.client.model.Client;
import com.interbank.codechallenge.dto.ClientDTO;
import com.interbank.codechallenge.entity.ClientEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author : Erojas
 * <ul>
 * <li> dateCreation : 21/12/2022 22 </li>
 * <li> fileName : IClientMapperTest.java </li>
 * <li> description : Represent ClientMapper PU </li>
 * </ul>
 */
class IClientMapperTest {
    private final IClientMapper mapper = Mappers.getMapper(IClientMapper.class);

    @Test
    @DisplayName("Entity to DTO")
    void entityToDto() {
        ClientEntity entity = new ClientEntity();
        entity.setFirstName("Juan");
        entity.setLastName("Soto Espinoza");
        entity.setDocumentType("12345678");
        entity.setDocumentNumber("DNI");

        ClientDTO dto = mapper.entityToDto(entity);
        assertTrue(this.isEquals(dto, entity));
    }

    @Test
    @DisplayName("DTO to Entity")
    void dtoToEntity() {
        ClientDTO dto = new ClientDTO();
        dto.setFirstName("Juan");
        dto.setLastName("Soto Espinoza");
        dto.setDocumentType("12345678");
        dto.setDocumentNumber("DNI");

        ClientEntity entity = mapper.dtoToEntity(dto);
        assertTrue(this.isEquals(dto, entity));
    }

    @Test
    @DisplayName("DTO to API")
    void dtoToApi() {
        ClientDTO dto = new ClientDTO();
        dto.setFirstName("Juan");
        dto.setLastName("Soto Espinoza");
        dto.setDocumentType("12345678");
        dto.setDocumentNumber("DNI");

        Client api = mapper.dtoToApi(dto);
        assertTrue(this.isEquals(api, dto));
    }

    @Test
    @DisplayName("API to DTO")
    void apiToDto() {
        Client api = new Client();
        api.setNombres("Juan");
        api.setApellidos("Soto Espinoza");
        api.setTipoDocumento("12345678");
        api.setNumeroDocumento("DNI");

        ClientDTO dto = mapper.apiToDto(api);
        assertTrue(this.isEquals(api, dto));
    }

    /**
     * Compare DTO with entity
     *
     * @param expected
     * @param current
     * @return
     */
    public boolean isEquals(ClientDTO expected, ClientEntity current) {
        return expected.getFirstName().equals(current.getFirstName()) &&
                expected.getLastName().equals(current.getLastName()) &&
                expected.getDocumentType().equals(current.getDocumentType()) &&
                expected.getDocumentNumber().equals(current.getDocumentNumber());
    }

    /**
     * Compare DTO with api
     *
     * @param expected
     * @param current
     * @return
     */
    public boolean isEquals(Client expected, ClientDTO current) {
        return expected.getNombres().equals(current.getFirstName()) &&
                expected.getApellidos().equals(current.getLastName()) &&
                expected.getTipoDocumento().equals(current.getDocumentType()) &&
                expected.getNumeroDocumento().equals(current.getDocumentNumber());
    }
}
