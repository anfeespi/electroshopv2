package co.edu.unbosque.electroshopv2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Entidad que representa un Pedido en el sistema.
 * 
 * Esta clase almacena la información de un pedido realizado por un cliente,
 * incluyendo la referencia al cliente, método de pago y el valor total del pedido.
 * 
 * @linkEntity: Define esta clase como una entidad en la base de datos.
 * @linkTable}: Especifica la tabla en la base de datos a la que está mapeada esta entidad.
 * @linkManyToOne}: Indica una relación muchos-a-uno con la entidad @linkClient y @linkPaymentMethod.
 * @linkGeneratedValue}: Genera automáticamente el valor del ID del pedido.
 * @linkSchema: Proporciona información adicional para la documentación de Swagger.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@Entity
@Table(name = "pedidos")
@Schema(description = "Entidad que representa un Pedido en el sistema.")
public class Order {

    /**
     * Identificador único del pedido.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedido")
    @Schema(description = "Identificador único del pedido", example = "1")
    private Integer orderId;

    /**
     * Cliente asociado al pedido.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @Schema(description = "Cliente que realizó el pedido", example = "12345678")
    private Client client;

    /**
     * Método de pago utilizado en el pedido.
     */
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_met_pago")
    @Schema(description = "Método de pago utilizado en el pedido", example = "Tarjeta de crédito")
    private PaymentMethod paymentMethod;

    /**
     * Valor total del pedido.
     */
    @Column(name = "valor_total")
    @Schema(description = "Valor total del pedido", example = "150000")
    private Long totalValue;

    /**
     * Constructor por defecto.
     */
    public Order() {
        // Constructor vacío
    }

    /**
     * Constructor con parámetros para inicializar un pedido.
     * 
     * @param client        Cliente que realizó el pedido.
     * @param paymentMethod Método de pago utilizado.
     * @param totalValue    Valor total del pedido.
     */
    public Order(Client client, PaymentMethod paymentMethod, Long totalValue) {
        super();
        this.client = client;
        this.paymentMethod = paymentMethod;
        this.totalValue = totalValue;
    }

    /**
     * Obtiene el identificador del pedido.
     * 
     * @return Identificador del pedido.
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * Establece el identificador del pedido.
     * 
     * @param orderId Identificador del pedido.
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * Obtiene el cliente que realizó el pedido.
     * 
     * @return Cliente que realizó el pedido.
     */
    public Client getClient() {
        return client;
    }

    /**
     * Establece el cliente que realizó el pedido.
     * 
     * @param client Cliente que realizó el pedido.
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Obtiene el método de pago utilizado en el pedido.
     * 
     * @return Método de pago utilizado.
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Establece el método de pago utilizado en el pedido.
     * 
     * @param paymentMethod Método de pago utilizado.
     */
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Obtiene el valor total del pedido.
     * 
     * @return Valor total del pedido.
     */
    public Long getTotalValue() {
        return totalValue;
    }

    /**
     * Establece el valor total del pedido.
     * 
     * @param totalValue Valor total del pedido.
     */
    public void setTotalValue(Long totalValue) {
        this.totalValue = totalValue;
    }

    /**
     * Retorna una representación en cadena del pedido.
     * 
     * @return Cadena representando el pedido.
     */
    @Override
    public String toString() {
        return "Order [orderId=" + orderId + ", client=" + client + ", paymentMethod=" + paymentMethod + ", totalValue="
                + totalValue + "]";
    }
}
