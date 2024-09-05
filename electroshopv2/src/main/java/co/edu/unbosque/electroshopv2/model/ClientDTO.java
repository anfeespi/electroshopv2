package co.edu.unbosque.electroshopv2.model;

import java.util.Set;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import jakarta.validation.constraints.NotBlank;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * (DTO) que representa los datos de un cliente en el sistema.
 * 
 * Esta clase es utilizada para transferir información entre las capas de la aplicación,
 * asegurando que los datos del cliente sean validados adecuadamente antes de ser procesados.
 * Incluye validaciones de longitud, formato y obligatoriedad en los campos principales.
 * 
 * @linkLength: Para validar la longitud de ciertos campos.
 * @linkNotBlank: Para asegurar que ciertos campos no estén vacíos.
 * @linkRange: Para validar rangos numéricos.
 * 
 * @linkSchema: Proporciona información adicional para la generación de documentación con Swagger.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@Schema(description = "DTO que contiene los datos básicos de un cliente, incluyendo sus órdenes")
public class ClientDTO {

    /**
     * Identificación del cliente (cédula), debe tener entre 7 y 10 caracteres.
     */
    @Schema(description = "Identificación del cliente (cédula), longitud entre 7 y 10 caracteres", example = "12345678")
    @Length(min = 7, max = 10, message = "Formato incorrecto de la cédula")
    @NotBlank(message = "La cédula no puede estar en blanco")
    private String clientId;

    /**
     * Nombre del cliente, con una longitud máxima de 50 caracteres.
     */
    @Schema(description = "Nombre del cliente, longitud máxima de 50 caracteres", example = "Juan Pérez")
    @Length(max = 50, message = "El nombre es demasiado largo")
    @NotBlank(message = "Ups! ese nombre es del hombre invisible")
    private String name;

    /**
     * Edad del cliente, debe estar entre 18 y 150 años.
     */
    @Schema(description = "Edad del cliente, debe estar entre 18 y 150 años", example = "30")
    @Range(min = 18, max = 150, message = "La edad no es adecuada para hacer compras")
    @NotBlank(message = "La edad no puede ser vacía")
    private Integer age;

    /**
     * Dirección del cliente, no puede estar vacía.
     */
    @Schema(description = "Dirección del cliente", example = "Calle 123 #45-67")
    @NotBlank(message = "La dirección no debe ser vacía")
    private String address;

    /**
     * Conjunto de identificadores de órdenes asociadas al cliente.
     */
    @Schema(description = "Conjunto de identificadores de órdenes asociadas al cliente")
    private Set<Integer> orders;

    /**
     * Constructor por defecto.
     */
    public ClientDTO() {
        // Constructor vacío
    }

    /**
     * Constructor con parámetros para inicializar un cliente.
     * 
     * @param clientId Identificación del cliente.
     * @param name     Nombre del cliente.
     * @param age      Edad del cliente.
     * @param address  Dirección del cliente.
     * @param orders   Conjunto de identificadores de órdenes.
     */
    public ClientDTO(
            @Length(min = 7, max = 10, message = "Formato incorrecto de la cédula") @NotBlank(message = "La cédula no puede estar en blanco") String clientId,
            @Length(max = 50, message = "El nombre es demasiado largo") @NotBlank(message = "Ups! ese nombre es del hombre invisible") String name,
            @Range(min = 18, max = 150, message = "La edad no es adecuada para hacer compras") @NotBlank(message = "La edad no puede ser vacía") Integer age,
            @NotBlank(message = "La dirección no debe ser vacía") String address, Set<Integer> orders) {
        super();
        this.clientId = clientId;
        this.name = name;
        this.age = age;
        this.address = address;
        this.orders = orders;
    }

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the orders
	 */
	public Set<Integer> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Set<Integer> orders) {
		this.orders = orders;
	}
	
}
