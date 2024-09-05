package co.edu.unbosque.electroshopv2.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Clase que representa una clave primaria compuesta para la entidad @linkOrderDetail.
 * 
 * Esta clase se utiliza como clave primaria embebida en la entidad de detalles del pedido,
 * combinando las referencias a la entidad @linkOrder y a la entidad @linkProduct.
 * Esto permite establecer una relación de muchos a muchos entre pedidos y productos.
 * 
 * @linkEmbeddable}: Marca esta clase como una clave primaria compuesta para ser utilizada dentro de otra entidad.
 * @linkManyToOne}: Define relaciones de muchos a uno con las entidades {@link Order} y {@link Product}.
 * @linkJoinColumn}: Especifica la columna de unión en la base de datos.
 * @linkSchema Proporciona información adicional para la documentación de Swagger.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@Embeddable
@Schema(description = "Clase que representa la clave primaria compuesta de la entidad Detalle del Pedido, asociando un Pedido y un Producto.")
public class EmbeddedIdOrderDetail {

    /**
     * Referencia a la entidad @linkOrder asociada a esta clave compuesta.
     */
    @Schema(description = "Referencia al pedido asociado", example = "1")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private Order order;

    /**
     * Referencia a la entidad @linkProduct asociada a esta clave compuesta.
     */
    @Schema(description = "Referencia al producto asociado", example = "101")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private Product product;

    /**
     * Constructor por defecto.
     */
    public EmbeddedIdOrderDetail() {
        // Constructor vacío
    }

    /**
     * Constructor con parámetros que inicializa el pedido y el producto asociados.
     * 
     * @param order   Pedido asociado.
     * @param product Producto asociado.
     */
    public EmbeddedIdOrderDetail(Order order, Product product) {
        super();
        this.order = order;
        this.product = product;
    }

    /**
     * Obtiene el pedido asociado a esta clave compuesta.
     * 
     * @return Pedido asociado.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Establece el pedido asociado a esta clave compuesta.
     * 
     * @param order Pedido a asociar.
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Obtiene el producto asociado a esta clave compuesta.
     * 
     * @return Producto asociado.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Establece el producto asociado a esta clave compuesta.
     * 
     * @param product Producto a asociar.
     */
    public void setProduct(Product product) {
        this.product = product;
    }
}
