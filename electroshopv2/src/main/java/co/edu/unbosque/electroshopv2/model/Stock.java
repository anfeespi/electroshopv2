package co.edu.unbosque.electroshopv2.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Entidad que representa el inventario de productos en la tienda. 
 * Contiene información sobre la cantidad disponible de un producto específico.
 */
@Entity
@Table(name = "inventarios")
public class Stock {

    /**
     * Identificador único del inventario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stock")
    private Integer stockId;

    /**
     * Producto al cual pertenece este inventario.
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private Product product;

    /**
     * Cantidad disponible en el inventario para el producto.
     */
    @Column(name = "cantidad_stock")
    private Integer stock;

    /**
     * Constructor por defecto.
     */
    public Stock() {
        // Constructor vacío
    }

    /**
     * Constructor que inicializa todos los atributos de la clase.
     *
     * @param stockId Identificador único del inventario.
     * @param product Producto al cual pertenece este inventario.
     * @param stock   Cantidad disponible en el inventario para el producto.
     */
    public Stock(Integer stockId, Product product, Integer stock) {
        this.stockId = stockId;
        this.product = product;
        this.stock = stock;
    }

    /**
     * Obtiene el identificador único del inventario.
     *
     * @return El identificador del inventario.
     */
    public Integer getStockId() {
        return stockId;
    }

    /**
     * Establece el identificador único del inventario.
     *
     * @param stockId El identificador del inventario.
     */
    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    /**
     * Obtiene el producto al cual pertenece este inventario.
     *
     * @return El producto asociado al inventario.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Establece el producto al cual pertenece este inventario.
     *
     * @param product El producto a asociar al inventario.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Obtiene la cantidad disponible en el inventario para el producto.
     *
     * @return La cantidad disponible en el inventario.
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * Establece la cantidad disponible en el inventario para el producto.
     *
     * @param stock La cantidad disponible en el inventario.
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
