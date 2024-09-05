package co.edu.unbosque.electroshopv2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Clase que representa una excepción personalizada para manejar casos en los que
 * un recurso no es encontrado en la aplicación.
 * 
 * Esta excepción será lanzada cuando se intente acceder a un recurso que no existe
 * y será mapeada con el código de estado HTTP 404 (NOT FOUND).
 * 
 * Extiende de RuntimeException lo que permite que sea una excepción no chequeada.
 * 
 * @ResponseStatus: Indica el código de estado HTTP que será retornado cuando esta
 * excepción sea lanzada. En este caso, se usa @HttpStatus.NOT_FOUND para devolver
 * un código 404.
 * 
 * Si en un controlador de la API se intenta buscar un producto por ID y dicho producto
 * no existe, esta excepción puede ser lanzada para notificar al cliente que el recurso
 * solicitado no fue encontrado.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor por defecto que llama al constructor de la superclase.
     * 
     * No proporciona un mensaje de error adicional.
     */
    public NotFoundException() {
        super();
    }

    /**
     * Constructor que permite especificar un mensaje de error personalizado.
     * 
     * @param message Mensaje de error que será asociado a esta excepción.
     */
    public NotFoundException(String message) {
        super(message);
    }
}
