package co.edu.unbosque.electroshopv2.model;

import org.hibernate.validator.constraints.Range;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * (DTO) para representar un pedido en el sistema. Esta clase se utiliza para
 * transferir la información del pedido entre las capas de la aplicación.
 * 
 * Se valida que todos los campos sean válidos y no nulos, además de que el
 * valor total no sea cero.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@Schema(description = "Modelo para representar un pedido en el sistema.")
public class OrderDTO {

	/** El identificador del pedido */
	@Schema(description = "Identificador único del pedido", example = "1001", required = true)
	@NotNull(message = "El pedido no tiene identificador")
	private Integer orderId;

	/** El nombre del cliente asociado al pedido */
	@Schema(description = "Nombre del cliente asociado al pedido", example = "Juan Perez", required = true)
	@NotBlank(message = "El cliente no está asociado")
	private String client;

	/** El método de pago utilizado en el pedido */
	@Schema(description = "Método de pago utilizado en el pedido", required = true)
	@JsonBackReference
	@NotNull(message = "Se debe asociar un método de pago")
	private PaymentMethod paymentMethod;

	/** El valor total del pedido */
	@Schema(description = "Valor total del pedido", example = "50000", required = true, minimum = "0")
	@Range(min = 0, message = "El valor de la compra no debe ser 0")
	private Long totalValue;

	/**
	 * Constructor vacío.
	 */
	public OrderDTO() {
		// Constructor por defecto
	}

	/**
	 * Constructor con parámetros para inicializar el DTO.
	 * 
	 * @param orderId       El identificador del pedido
	 * @param client        El cliente que realizó el pedido
	 * @param paymentMethod El método de pago utilizado
	 * @param totalValue    El valor total de la compra
	 */
	public OrderDTO(@NotNull(message = "El pedido no tiene identificador") Integer orderId,
			@NotBlank(message = "El cliente no está asociado") String client,
			@NotNull(message = "Se debe asociar un método de pago") PaymentMethod paymentMethod,
			@Range(min = 0, message = "El valor de la compra no debe ser 0") Long totalValue) {
		super();
		this.orderId = orderId;
		this.client = client;
		this.paymentMethod = paymentMethod;
		this.totalValue = totalValue;
	}

	/**
	 * @return El identificador del pedido.
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * Establece el identificador del pedido.
	 * 
	 * @param orderId El identificador del pedido
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * @return El cliente asociado al pedido.
	 */
	public String getClientDTO() {
		return client;
	}

	/**
	 * Establece el cliente que realizó el pedido.
	 * 
	 * @param client El cliente a establecer
	 */
	public void setClientDTO(String client) {
		this.client = client;
	}

	/**
	 * @return El método de pago utilizado.
	 */
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	/**
	 * Establece el método de pago utilizado.
	 * 
	 * @param paymentMethod El método de pago a establecer
	 */
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	/**
	 * @return El valor total del pedido.
	 */
	public Long getTotalValue() {
		return totalValue;
	}

	/**
	 * Establece el valor total del pedido.
	 * 
	 * @param totalValue El valor total a establecer
	 */
	public void setTotalValue(Long totalValue) {
		this.totalValue = totalValue;
	}
}
