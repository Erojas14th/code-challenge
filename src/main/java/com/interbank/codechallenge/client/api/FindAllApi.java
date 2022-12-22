/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.interbank.codechallenge.client.api;

import com.interbank.codechallenge.client.model.Client;
import com.interbank.codechallenge.client.model.Error;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import javax.validation.constraints.*;
import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-12-22T08:47:28.107-05:00")

@Api(value = "findAll", description = "the findAll API")
public interface FindAllApi {

    @ApiOperation(value = "", notes = "Find all clients information", response = Client.class, responseContainer = "List", tags={ "findAll", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = Client.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "BAD REQUEST", response = Error.class),
        @ApiResponse(code = 404, message = "NOT FOUND", response = Error.class),
        @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR", response = Error.class) })
    
    @RequestMapping(value = "/findAll",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Client>> findAll();

}