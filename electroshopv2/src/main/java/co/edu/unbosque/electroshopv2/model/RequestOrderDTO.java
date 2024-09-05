package co.edu.unbosque.electroshopv2.model;

import java.util.List;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Clase que representa la solicitud de un pedido, incluyendo los detalles de la
 * orden, la tarjeta utilizada para el pago y los detalles de los productos.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@Schema(description = "Solicitud de pedido que incluye detalles de la orden, tarjeta de pago y productos.")
public class RequestOrderDTO {

	/**
	 * Objeto que contiene los detalles del pedido.
	 */
	@Schema(description = "Detalles del pedido", required = true)
	@NotNull(message = "El pedido no puede estar vacío")
	private OrderDTO orderDTO;

	/**
	 * Objeto que contiene los detalles de la tarjeta utilizada para el pago.
	 */
	@Schema(description = "Detalles de la tarjeta utilizada para el pago", required = true)
	@NotNull(message = "La tarjeta no puede ser vacía")
	private CardDTO cardDTO;

	/**
	 * Lista que contiene los detalles de los productos incluidos en la orden.
	 */
	@Schema(description = "Detalles de los productos incluidos en la orden", required = true)
	@NotNull(message = "Se deben incluir productos")
	private List<OrderDetailDTO> orderDetails;

	/**
	 * Constructor por defecto.
	 */
	public RequestOrderDTO() {
		// Constructor vacío
	}

	/**
	 * Constructor que inicializa todos los atributos de la clase.
	 *
	 * @param orderDTO     Objeto que contiene los detalles del pedido.
	 * @param cardDTO      Objeto que contiene los detalles de la tarjeta utilizada
	 *                     para el pago.
	 * @param orderDetails Lista que contiene los detalles de los productos
	 *                     incluidos en la orden.
	 */
	public RequestOrderDTO(@NotNull(message = "El pedido no puede estar vacío") OrderDTO orderDTO,
			@NotNull(message = "La tarjeta no puede ser vacía") CardDTO cardDTO,
			@NotNull(message = "Se deben incluir productos") List<OrderDetailDTO> orderDetails) {
		this.orderDTO = orderDTO;
		this.cardDTO = cardDTO;
		this.orderDetails = orderDetails;
	}

	/**
	 * Obtiene los detalles del pedido.
	 *
	 * @return Un objeto {@link OrderDTO} con los detalles del pedido.
	 */
	public OrderDTO getOrderDTO() {
		return orderDTO;
	}

	/**
	 * Establece los detalles del pedido.
	 *
	 * @param orderDTO Un objeto {@link OrderDTO} con los detalles del pedido.
	 */
	public void setOrderDTO(OrderDTO orderDTO) {
		this.orderDTO = orderDTO;
	}

	/**
	 * Obtiene los detalles de la tarjeta utilizada para el pago.
	 *
	 * @return Un objeto {@link CardDTO} con los detalles de la tarjeta.
	 */
	public CardDTO getCardDTO() {
		return cardDTO;
	}

	/**
	 * Establece los detalles de la tarjeta utilizada para el pago.
	 *
	 * @param cardDTO Un objeto {@link CardDTO} con los detalles de la tarjeta.
	 */
	public void setCardDTO(CardDTO cardDTO) {
		this.cardDTO = cardDTO;
	}

	/**
	 * Obtiene los detalles de los productos incluidos en la orden.
	 *
	 * @return Una lista de objetos {@link OrderDetailDTO} con los detalles de los
	 *         productos.
	 */
	public List<OrderDetailDTO> getOrderDetails() {
		return orderDetails;
	}

	/**
	 * Establece los detalles de los productos incluidos en la orden.
	 *
	 * @param orderDetails Una lista de objetos {@link OrderDetailDTO} con los
	 *                     detalles de los productos.
	 */
	public void setOrderDetails(List<OrderDetailDTO> orderDetails) {
		this.orderDetails = orderDetails;
	}
}
