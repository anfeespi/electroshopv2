package co.edu.unbosque.electroshopv2.model;

import org.hibernate.validator.constraints.Length;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * (DTO) que representa los datos de una tarjeta de crédito.
 * 
 * Esta clase se utiliza para capturar y transferir la información relacionada
 * con una tarjeta de crédito como parte de las operaciones de la API. Incluye
 * validaciones para asegurar que los datos de la tarjeta sean correctos en
 * términos de longitud y formato.
 * 
 * @linkLength Se utiliza para validar la longitud de los atributos de la
 *             tarjeta.
 * 
 * @linkSchema Proporciona información adicional para describir los campos de
 *             esta clase.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */

@Schema(description = "Modelo para los detalles la tarjeta de credito, contiene la información de una tarjeta de credito.")
public class CardDTO {

	/**
	 * Número de la tarjeta de crédito. Debe tener entre 16 y 19 dígitos.
	 */
	@Schema(description = "Número de la tarjeta de crédito, debe tener entre 16 y 19 dígitos")
	@Length(min = 16, max = 19, message = "El número de la tarjeta es incorrecto")
	private String number;

	/**
	 * Fecha de expiración de la tarjeta de crédito. Debe tener entre 4 y 5
	 * caracteres.
	 */
	@Schema(description = "Fecha de expiración de la tarjeta en formato MM/YY o MMYY")
	@Length(min = 4, max = 5, message = "La expiración es incorrecta")
	private String expiration;

	/**
	 * Código de seguridad de la tarjeta de crédito (CVC). Debe tener 3 dígitos.
	 */
	@Schema(description = "Código de seguridad de la tarjeta (CVC), debe tener 3 dígitos")
	@Length(min = 3, max = 3, message = "La clave de seguridad no es correcta")
	private String cvc;

	/**
	 * Constructor por defecto.
	 */
	public CardDTO() {
		// Constructor vacío
	}

	/**
	 * Constructor con todos los atributos de la tarjeta de crédito.
	 * 
	 * @param number     El número de la tarjeta de crédito.
	 * @param expiration La fecha de expiración de la tarjeta.
	 * @param cvc        El código de seguridad de la tarjeta.
	 */
	public CardDTO(String number, String expiration, String cvc) {
		super();
		this.number = number;
		this.expiration = expiration;
		this.cvc = cvc;
	}

	/**
	 * Obtiene el número de la tarjeta de crédito.
	 * 
	 * @return El número de la tarjeta.
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Establece el número de la tarjeta de crédito.
	 * 
	 * @param number El número de la tarjeta.
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Obtiene la fecha de expiración de la tarjeta de crédito.
	 * 
	 * @return La fecha de expiración.
	 */
	public String getExpiration() {
		return expiration;
	}

	/**
	 * Establece la fecha de expiración de la tarjeta de crédito.
	 * 
	 * @param expiration La fecha de expiración.
	 */
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}

	/**
	 * Obtiene el código de seguridad de la tarjeta de crédito (CVC).
	 * 
	 * @return El código de seguridad (CVC).
	 */
	public String getCvc() {
		return cvc;
	}

	/**
	 * Establece el código de seguridad de la tarjeta de crédito (CVC).
	 * 
	 * @param cvc El código de seguridad.
	 */
	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
}
