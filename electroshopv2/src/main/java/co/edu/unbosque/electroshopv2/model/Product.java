package co.edu.unbosque.electroshopv2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Clase que representa un producto en el sistema.
 * Esta clase mapea la tabla "productos" en la base de datos, donde se almacenan los detalles de cada producto.
 * 
 * Cada producto está asociado a una categoría de producto y puede tener un stock disponible.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@Entity
@Table(name = "productos")
public class Product {

    /** Identificador único del producto */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer productId;
    
    /** Nombre del producto */
    @Column(name = "nom_producto")
    private String name;
    
    /** Precio del producto */
    @Column(name = "precio_producto")
    private Long value;
    
    /** Categoría a la que pertenece el producto */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria_producto")
    private ProductCategory category;
    
    /** Relación uno a uno con la tabla de stock */
    @OneToOne(mappedBy = "product")
    private Stock stock;

    /**
     * Constructor vacío.
     */
    public Product() {
        // Constructor por defecto
    }

    /**
     * Constructor con parámetros para inicializar un producto.
     * 
     * @param name Nombre del producto
     * @param value Precio del producto
     * @param category Categoría del producto
     */
    public Product(String name, Long value, ProductCategory category) {
        super();
        this.name = name;
        this.value = value;
        this.category = category;
    }

    /**
     * @return El identificador del producto.
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * Establece el identificador del producto.
     * 
     * @param productId El identificador del producto
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * @return El nombre del producto.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del producto.
     * 
     * @param name El nombre del producto
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return El valor del producto.
     */
    public Long getValue() {
        return value;
    }

    /**
     * Establece el valor del producto.
     * 
     * @param value El valor del producto
     */
    public void setValue(Long value) {
        this.value = value;
    }

    /**
     * @return La categoría del producto.
     */
    public ProductCategory getCategory() {
        return category;
    }

    /**
     * Establece la categoría del producto.
     * 
     * @param category La categoría del producto
     */
    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    /**
     * @return El stock asociado al producto.
     */
    public Stock getStock() {
        return stock;
    }

    /**
     * Establece el stock del producto.
     * 
     * @param stock El stock a establecer
     */
    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
