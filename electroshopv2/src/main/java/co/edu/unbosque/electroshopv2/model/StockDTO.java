package co.edu.unbosque.electroshopv2.model;

import org.hibernate.validator.constraints.Range;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;

/**
 * Clase DTO que representa el inventario de productos en la tienda. 
 * Incluye información sobre la cantidad disponible de un producto específico.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
public class StockDTO {

    /**
     * Identificador único del inventario.
     */
    @NotNull(message = "El identificador no debe ser vacío")
    private Integer stockId;

    /**
     * Producto asociado a este inventario.
     */
    @JsonManagedReference
    @NotNull(message = "Producto no especificado")
    private ProductDTO product;

    /**
     * Cantidad disponible en el inventario para el producto.
     * Debe ser mayor o igual a 1.
     */
    @Range(min = 1, message = "Cantidad no aceptada")
    private Integer stock;

    /**
     * Constructor por defecto.
     */
    public StockDTO() {
        // Constructor vacío
    }

    /**
     * Constructor que inicializa todos los atributos de la clase.
     *
     * @param stockId  Identificador único del inventario.
     * @param product  Producto asociado a este inventario.
     * @param stock    Cantidad disponible en el inventario para el producto.
     */
    public StockDTO(@NotNull(message = "El identificador no debe ser vacío") Integer stockId,
                    @NotNull(message = "Producto no especificado") ProductDTO product,
                    @Range(min = 1, message = "Cantidad no aceptada") Integer stock) {
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
     * Obtiene el producto asociado a este inventario.
     *
     * @return El producto asociado al inventario.
     */
    public ProductDTO getProduct() {
        return product;
    }

    /**
     * Establece el producto asociado a este inventario.
     *
     * @param product El producto a asociar al inventario.
     */
    public void setProduct(ProductDTO product) {
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
