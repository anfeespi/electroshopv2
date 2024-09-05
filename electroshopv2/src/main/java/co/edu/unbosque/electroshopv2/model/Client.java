package co.edu.unbosque.electroshopv2.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Entidad que representa a un cliente en el sistema.
 * 
 * Esta clase mapea a la tabla "clientes" de la base de datos y contiene
 * información relevante de cada cliente, como su nombre, edad, dirección
 * y las órdenes que ha realizado.
 * 
 * Las relaciones con otras entidades @linkOrder, también están
 * definidas en esta clase.
 * 
 * @linkEntity: Marca esta clase como una entidad de JPA.
 * @linkTable: Define el nombre de la tabla a la cual está mapeada esta entidad.
 * @linkOneToMany: Relación uno a muchos con la entidad {@link Order}.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@Entity
@Table(name = "clientes")
@Schema(description = "Entidad que representa a un cliente con sus datos y sus órdenes asociadas.")
public class Client {

    /**
     * Identificador único del cliente.
     */
    @Schema(description = "Identificador único del cliente", example = "12345ABC")
    @Id
    @Column(name = "id_cliente", unique = true)
    private String clientId;

    /**
     * Nombre del cliente. Longitud máxima de 50 caracteres.
     */
    @Schema(description = "Nombre del cliente", example = "Juan Pérez")
    @Column(name = "nom_cliente", length = 50)
    private String name;

    /**
     * Edad del cliente.
     */
    @Schema(description = "Edad del cliente", example = "30")
    @Column(name = "edad_cliente")
    private Integer age;

    /**
     * Dirección del cliente.
     */
    @Schema(description = "Dirección del cliente", example = "Calle 123 #45-67")
    @Column(name = "direccion")
    private String address;

    /**
     * Conjunto de órdenes realizadas por el cliente.
     * 
     * Relación uno a muchos con la entidad @linkOrder.
     */
    @Schema(description = "Conjunto de órdenes realizadas por el cliente")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Order> orders;

    /**
     * Constructor por defecto.
     */
    public Client() {
        // Constructor vacío
    }

    /**
     * Constructor que inicializa un cliente con los atributos especificados.
     * 
     * @param name    Nombre del cliente.
     * @param age     Edad del cliente.
     * @param address Dirección del cliente.
     */
    public Client(String name, Integer age, String address) {
        super();
        this.name = name;
        this.age = age;
        this.address = address;
    }

    /**
     * Obtiene el identificador único del cliente.
     * 
     * @return Identificador del cliente.
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * Establece el identificador único del cliente.
     * 
     * @param clientId Identificador del cliente.
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * Obtiene el nombre del cliente.
     * 
     * @return Nombre del cliente.
     */
    public String getName() {
        return name;
    }

    /**
     * Establece el nombre del cliente.
     * 
     * @param name Nombre del cliente.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtiene la edad del cliente.
     * 
     * @return Edad del cliente.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Establece la edad del cliente.
     * 
     * @param age Edad del cliente.
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Obtiene la dirección del cliente.
     * 
     * @return Dirección del cliente.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Establece la dirección del cliente.
     * 
     * @param address Dirección del cliente.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Obtiene el conjunto de órdenes realizadas por el cliente.
     * 
     * @return Conjunto de órdenes del cliente.
     */
    public Set<Order> getOrders() {
        return orders;
    }

    /**
     * Establece el conjunto de órdenes realizadas por el cliente.
     * 
     * @param orders Conjunto de órdenes.
     */
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
