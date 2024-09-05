package co.edu.unbosque.electroshopv2.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Clase que representa los detalles de un pedido en el sistema.
 * Esta clase mapea la tabla "detalles_pedido" en la base de datos, donde se almacena la información
 * relacionada con los productos solicitados en cada pedido.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@Entity
@Table(name = "detalles_pedido")
public class OrderDetail {
	
    /**
     * Identificador compuesto para el detalle del pedido. Este identificador se almacena
     * como clave primaria compuesta utilizando la clase @linkEmbeddedIdOrderDetail.
     */
	@EmbeddedId
	private EmbeddedIdOrderDetail orderDetailId;
	
    /**
     * Cantidad de producto solicitada en el pedido.
     */
	@Column(name = "cantidad_producto_pedido")
	private Integer quantity;

	/**
	 * Constructor vacío por defecto.
	 */
	public OrderDetail() {
		// Constructor por defecto
	}

	/**
	 * Constructor que permite inicializar el objeto con los parámetros necesarios.
	 * 
	 * @param orderDetailId el identificador compuesto del detalle del pedido
	 * @param quantity la cantidad de producto solicitada en el pedido
	 */
	public OrderDetail(EmbeddedIdOrderDetail orderDetailId, Integer quantity) {
		super();
		this.orderDetailId = orderDetailId;
		this.quantity = quantity;
	}

	/**
	 * Obtiene el identificador compuesto del detalle del pedido.
	 * 
	 * @return el identificador compuesto del detalle del pedido
	 */
	public EmbeddedIdOrderDetail getOrderDetailId() {
		return orderDetailId;
	}

	/**
	 * Establece el identificador compuesto del detalle del pedido.
	 * 
	 * @param orderDetailId el nuevo identificador compuesto del detalle del pedido
	 */
	public void setOrderDetailId(EmbeddedIdOrderDetail orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	/**
	 * Obtiene la cantidad de producto solicitada.
	 * 
	 * @return la cantidad de producto solicitada
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * Establece la cantidad de producto solicitada.
	 * 
	 * @param quantity la nueva cantidad de producto solicitada
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
