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

/**
 * Clase que representa la categoría de un producto en el sistema. Esta clase
 * mapea la tabla "categorias_producto" en la base de datos, donde se almacenan
 * las categorías a las que pertenecen los productos.
 * 
 * Cada categoría puede estar asociada a múltiples productos.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@Entity
@Table(name = "categorias_producto")
public class ProductCategory {

	/** Identificador único de la categoría del producto */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria_producto")
	private Integer categoryId;

	/** Nombre de la categoría del producto */
	@Column(name = "nombre_producto", length = 50)
	private String name;

	/** Productos asociados a la categoría */
	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
	private Set<Product> products;

	/**
	 * Constructor vacío.
	 */
	public ProductCategory() {
		// Constructor por defecto
	}

	/**
	 * Constructor con parámetros para inicializar una categoría de producto.
	 * 
	 * @param name Nombre de la categoría
	 */
	public ProductCategory(String name) {
		super();
		this.name = name;
	}

	/**
	 * @return El identificador de la categoría del producto.
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * Establece el identificador de la categoría del producto.
	 * 
	 * @param categoryId El identificador a establecer
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return El nombre de la categoría.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Establece el nombre de la categoría.
	 * 
	 * @param name El nombre a establecer
	 */
	public void setName(String name) {
		this.name = name;
	}
}
