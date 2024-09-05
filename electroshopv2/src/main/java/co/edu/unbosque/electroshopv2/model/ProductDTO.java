package co.edu.unbosque.electroshopv2.model;

import org.hibernate.validator.constraints.Range;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Clase de transferencia de datos (DTO) para productos. Esta clase se utiliza
 * para transferir información de los productos entre las diferentes capas de la
 * aplicación, evitando exponer directamente las entidades.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@Schema(description = "DTO que representa un producto para la transferencia de datos entre capas.")
public class ProductDTO {

	/** Identificador único del producto */
	@Schema(description = "Identificador único del producto", example = "101", required = true)
	@NotBlank(message = "El producto no tiene identificador")
	private Integer productId;

	/** Nombre del producto */
	@Schema(description = "Nombre del producto", example = "Laptop", required = true)
	@NotBlank(message = "El nombre del producto no debe ser vacío")
	private String name;

	/** Precio del producto */
	@Schema(description = "Precio del producto", example = "1500", required = true)
	@Range(min = 0, message = "El producto debe tener un costo")
	private Long value;

	/** Categoría del producto */
	@Schema(description = "Categoría a la que pertenece el producto", required = true)
	@JsonBackReference
	@NotNull(message = "La categoría no debería ser vacía")
	private ProductCategory category;

	/** Información del stock del producto */
	@Schema(description = "Información de stock del producto", required = true)
	@JsonBackReference
	@NotNull(message = "El stock no está referenciado")
	private StockDTO stock;

	/**
	 * Constructor vacío.
	 */
	public ProductDTO() {
		// Constructor por defecto
	}

	/**
	 * Constructor con parámetros para inicializar un ProductDTO.
	 * 
	 * @param productId El identificador del producto
	 * @param name      El nombre del producto
	 * @param value     El valor o precio del producto
	 * @param category  La categoría a la que pertenece el producto
	 */
	public ProductDTO(@NotBlank(message = "El producto no tiene identificador") Integer productId,
			@NotBlank(message = "El nombre del producto no debe ser vacío") String name,
			@Range(min = 0, message = "El producto debe tener un costo") Long value,
			@NotNull(message = "La categoría no debería ser vacía") ProductCategory category) {
		super();
		this.productId = productId;
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
	 * @param productId El identificador a establecer
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
	 * @param name El nombre a establecer
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return El valor o precio del producto.
	 */
	public Long getValue() {
		return value;
	}

	/**
	 * Establece el valor o precio del producto.
	 * 
	 * @param value El valor a establecer
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
	 * @param category La categoría a establecer
	 */
	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	/**
	 * @return Información de stock del producto.
	 */
	public StockDTO getStock() {
		return stock;
	}

	/**
	 * Establece la información de stock del producto.
	 * 
	 * @param stock El stock a establecer
	 */
	public void setStock(StockDTO stock) {
		this.stock = stock;
	}
}
