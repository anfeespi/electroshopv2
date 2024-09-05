package co.edu.unbosque.electroshopv2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción personalizada para indicar que una tarjeta de crédito no es válida.
 * 
 * Esta excepción se lanza cuando se detecta que los datos de la tarjeta 
 * proporcionada no son válidos durante el procesamiento de un pedido.
 * 
 * La anotación @ResponseStatus establece el código de estado 
 * HTTP 402 (PAYMENT_REQUIRED) como respuesta cuando se lanza esta excepción, 
 * lo que significa que es necesaria una forma de pago válida.
 * 
 * Extiende la clase RuntimeException, por lo que es una excepción no verificada, 
 * lo que significa que no es obligatorio capturarla explícitamente en el código.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@ResponseStatus(value = HttpStatus.PAYMENT_REQUIRED)
public class CardNotValidException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * Constructor por defecto que crea una instancia de CardNotValidException.
     */
    public CardNotValidException() {
        super();
    }

    /**
     * Constructor que permite especificar un mensaje personalizado para la excepción.
     * 
     * @param message El mensaje que describe el error.
     */
    public CardNotValidException(String message) {
        super(message);
    }
}
