package co.edu.unbosque.electroshopv2.model;

import org.hibernate.validator.constraints.Range;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * (DTO) para los detalles de un pedido. Esta clase se utiliza para transferir
 * la información de los detalles del pedido entre las capas de la aplicación
 * sin necesidad de exponer la entidad directamente.
 * 
 * Se valida que los campos no sean nulos y que la cantidad sea válida.
 * 
 * @version 2.0
 */
@Schema(description = "Modelo para los detalles del pedido, contiene la información de un producto dentro de un pedido.")
public class OrderDetailDTO {

	/** El identificador del pedido */
	@Schema(description = "Identificador único del pedido", example = "1", required = true)
	@NotNull(message = "El pedido no está especificado")
	private Integer order;

	/** El identificador del producto */
	@Schema(description = "Identificador único del producto", example = "101", required = true)
	@NotNull(message = "El producto no está especificado")
	private Integer product;

	/** La cantidad del producto pedido, debe ser al menos 1 */
	@Schema(description = "Cantidad del producto solicitada", example = "2", required = true, minimum = "1")
	@Range(min = 1, message = "La cantidad no es la mínima")
	private Integer quantity;

	/**
	 * Constructor vacío.
	 */
	public OrderDetailDTO() {
		// Constructor por defecto
	}

	/**
	 * Constructor con parámetros para inicializar el DTO.
	 * 
	 * @param order    El identificador del pedido
	 * @param product  El identificador del producto
	 * @param quantity La cantidad de productos en el pedido
	 */
	public OrderDetailDTO(@NotNull(message = "El pedido no está especificado") Integer order,
			@NotNull(message = "El producto no está especificado") Integer product,
			@Range(min = 1, message = "La cantidad no es la mínima") Integer quantity) {
		super();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * @return El identificador del pedido.
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * Establece el identificador del pedido.
	 * 
	 * @param order El identificador del pedido
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}

	/**
	 * @return El identificador del producto.
	 */
	public Integer getProduct() {
		return product;
	}

	/**
	 * Establece el identificador del producto.
	 * 
	 * @param product El identificador del producto
	 */
	public void setProduct(Integer product) {
		this.product = product;
	}

	/**
	 * @return La cantidad de productos en el pedido.
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * Establece la cantidad de productos en el pedido.
	 * 
	 * @param quantity La cantidad a establecer
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
