package co.edu.unbosque.electroshopv2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción personalizada para manejar fallos en la creación de un recurso en la aplicación.
 * 
 * Esta excepción se lanza cuando no se puede crear un recurso por algún conflicto, 
 * como cuando un recurso ya existe o cuando hay algún otro tipo de error relacionado con la creación.
 * 
 * La clase extiende RuntimeException, permitiendo que se maneje como una excepción 
 * no verificada.
 * 
 * La anotación @ResponseStatus asigna el código de estado HTTP 409 (CONFLICT) cuando 
 * se lanza esta excepción.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class NotCreateException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor sin parámetros de la excepción NotCreateException.
     * 
     * Llama al constructor de la clase padre sin un mensaje específico.
     */
    public NotCreateException() {
        super();
    }

    /**
     * Constructor con un mensaje personalizado para la excepción NotCreateException.
     * 
     * Permite especificar un mensaje que describe el motivo de la excepción.
     * 
     * @param message Mensaje que describe el error.
     */
    public NotCreateException(String message) {
        super(message);
    }

}
