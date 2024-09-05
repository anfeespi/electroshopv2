package co.edu.unbosque.electroshopv2.repository;

import org.springframework.data.repository.CrudRepository;

import co.edu.unbosque.electroshopv2.model.EmbeddedIdOrderDetail;
import co.edu.unbosque.electroshopv2.model.OrderDetail;

/**
 * Repositorio para realizar operaciones CRUD
 * sobre la entidad @linkClient. 
 * Extiende de @linkCrudRepository proporcionado por Spring Data JPA.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */

public interface OrderDetailRepository extends CrudRepository<OrderDetail, EmbeddedIdOrderDetail>{

}
