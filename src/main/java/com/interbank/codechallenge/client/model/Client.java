package com.interbank.codechallenge.client.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Client
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-12-22T08:47:28.107-05:00")

public class Client  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("nombres")
  private String nombres = null;

  @JsonProperty("apellidos")
  private String apellidos = null;

  @JsonProperty("tipoDocumento")
  private String tipoDocumento = null;

  @JsonProperty("numeroDocumento")
  private String numeroDocumento = null;

  public Client nombres(String nombres) {
    this.nombres = nombres;
    return this;
  }

   /**
   * Represent firstName
   * @return nombres
  **/
  @ApiModelProperty(example = "Juan", value = "Represent firstName")


  public String getNombres() {
    return nombres;
  }

  public void setNombres(String nombres) {
    this.nombres = nombres;
  }

  public Client apellidos(String apellidos) {
    this.apellidos = apellidos;
    return this;
  }

   /**
   * Represent lastName
   * @return apellidos
  **/
  @ApiModelProperty(example = "Soto Espinoza", value = "Represent lastName")


  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public Client tipoDocumento(String tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
    return this;
  }

   /**
   * Represent document type such as DNI, RUC, etc
   * @return tipoDocumento
  **/
  @ApiModelProperty(example = "DNI", value = "Represent document type such as DNI, RUC, etc")


  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(String tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  public Client numeroDocumento(String numeroDocumento) {
    this.numeroDocumento = numeroDocumento;
    return this;
  }

   /**
   * Represent document number
   * @return numeroDocumento
  **/
  @ApiModelProperty(example = "12345678", value = "Represent document number")


  public String getNumeroDocumento() {
    return numeroDocumento;
  }

  public void setNumeroDocumento(String numeroDocumento) {
    this.numeroDocumento = numeroDocumento;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Client client = (Client) o;
    return Objects.equals(this.nombres, client.nombres) &&
        Objects.equals(this.apellidos, client.apellidos) &&
        Objects.equals(this.tipoDocumento, client.tipoDocumento) &&
        Objects.equals(this.numeroDocumento, client.numeroDocumento);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nombres, apellidos, tipoDocumento, numeroDocumento);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Client {\n");
    
    sb.append("    nombres: ").append(toIndentedString(nombres)).append("\n");
    sb.append("    apellidos: ").append(toIndentedString(apellidos)).append("\n");
    sb.append("    tipoDocumento: ").append(toIndentedString(tipoDocumento)).append("\n");
    sb.append("    numeroDocumento: ").append(toIndentedString(numeroDocumento)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

