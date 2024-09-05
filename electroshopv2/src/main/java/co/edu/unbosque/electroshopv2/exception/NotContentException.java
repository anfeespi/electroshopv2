package co.edu.unbosque.electroshopv2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción personalizada para manejar respuestas sin contenido en la aplicación.
 * 
 * Esta excepción se lanza cuando una operación se ejecuta correctamente, 
 * pero no hay datos para devolver, lo que corresponde a una respuesta HTTP 204.
 * 
 * La clase extiende RuntimeException, permitiendo que se maneje como una excepción 
 * no verificada.
 * 
 * La anotación @ResponseStatus asigna el código de estado HTTP 204 (NO_CONTENT) cuando 
 * se lanza esta excepción.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class NotContentException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor sin parámetros de la excepción NotContentException.
     * 
     * Llama al constructor de la clase padre sin un mensaje específico.
     */
    public NotContentException() {
        super();
    }

    /**
     * Constructor con un mensaje personalizado para la excepción NotContentException.
     * 
     * Permite especificar un mensaje que describe el motivo de la excepción.
     * 
     * @param message Mensaje que describe el error.
     */
    public NotContentException(String message) {
        super(message);
    }

}
