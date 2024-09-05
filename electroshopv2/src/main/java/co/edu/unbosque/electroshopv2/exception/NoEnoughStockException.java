package co.edu.unbosque.electroshopv2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción personalizada para manejar la falta de stock suficiente en un pedido.
 * 
 * Esta excepción se lanza cuando no hay suficiente stock disponible para procesar 
 * un pedido. Utiliza la anotación @ResponseStatus para devolver un código de estado 
 * HTTP 409 (CONFLICT) cuando se lanza esta excepción.
 * 
 * La clase extiende RuntimeException, lo que permite que se maneje como una excepción 
 * no verificada.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class NoEnoughStockException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor sin parámetros de la excepción NoEnoughStockException.
     * 
     * Llama al constructor de la clase padre.
     */
    public NoEnoughStockException() {
        super();
    }

    /**
     * Constructor con un mensaje personalizado para la excepción NoEnoughStockException.
     * 
     * @param message Mensaje personalizado que describe el error.
     */
    public NoEnoughStockException(String message) {
        super(message);
    }
}
