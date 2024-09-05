package co.edu.unbosque.electroshopv2.model;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Clase que representa los métodos de pago en el sistema. Esta clase mapea la
 * tabla "metodos_pago" en la base de datos, donde se almacenan los diferentes
 * métodos de pago disponibles. Cada método de pago puede estar asociado a
 * múltiples pedidos.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@Entity
@Table(name = "metodos_pago")
@Schema(description = "Entidad que representa un método de pago en el sistema.")
public class PaymentMethod {

	/** Identificador único del método de pago */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_met_pago")
	@Schema(description = "Identificador único del método de pago", example = "1")
	private Integer methodId;

	/** Nombre del método de pago */
	@Column(name = "nom_metodo_pago", length = 50)
	@Schema(description = "Nombre del método de pago", example = "Tarjeta de Crédito", required = true)
	private String name;

	/** Pedidos asociados al método de pago */
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "paymentMethod", cascade = CascadeType.ALL)
	@Schema(description = "Lista de pedidos asociados a este método de pago.")
	private Set<Order> orders;

	/**
	 * Constructor vacío.
	 */
	public PaymentMethod() {
		// Constructor por defecto
	}

	/**
	 * Constructor con parámetros para inicializar el método de pago.
	 * 
	 * @param name Nombre del método de pago
	 */
	public PaymentMethod(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return El identificador del método de pago.
	 */
	public Integer getMethodId() {
		return methodId;
	}

	/**
	 * Establece el identificador del método de pago.
	 * 
	 * @param methodId El identificador a establecer
	 */
	public void setMethodId(Integer methodId) {
		this.methodId = methodId;
	}

	/**
	 * @return El nombre del método de pago.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre del método de pago.
	 * 
	 * @param name El nombre a establecer
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Lista de pedidos asociados a este método de pago.
	 */
	public Set<Order> getOrders() {
		return orders;
	}

	/**
	 * Establece la lista de pedidos asociados a este método de pago.
	 * 
	 * @param orders La lista de pedidos a establecer
	 */
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}
