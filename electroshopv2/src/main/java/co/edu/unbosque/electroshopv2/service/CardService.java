package co.edu.unbosque.electroshopv2.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshopv2.exception.CardNotValidException;
import co.edu.unbosque.electroshopv2.model.CardDTO;
import jakarta.validation.Valid;

/**
 * Servicio encargado de la validación de tarjetas de crédito.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@Service
public class CardService {

	/**
	 * Valida la información de una tarjeta de crédito.
	 * 
	 * Este método verifica que el número de la tarjeta tenga 16 dígitos, que la
	 * fecha de expiración y el CVC sean válidos, y devuelve una cadena de texto
	 * indicando el estado de la transacción.
	 * 
	 * @param card Objeto @linkCardDTO que contiene la información de la tarjeta a
	 *             validar.
	 * @return Un mensaje indicando el resultado de la validación.
	 * @throws CardNotValidException Si la tarjeta no es válida.
	 * 
	 */
	public String validateCard(@Valid CardDTO card) {
		/**
		 * Validar el número de la tarjeta.
		 */
		if (!card.getNumber().replace("-", "").replace(".", "").replace(" ", "").replace("/", "").replace("\\", "")
				.matches("\\d+")) {
			throw new CardNotValidException("Hay caracteres en la tarjeta");
		}

		if (card.getNumber().replace("-", "").replace(".", "").replace(" ", "").replace("/", "").replace("\\", "")
				.length() != 16) {
			throw new CardNotValidException("Número de tarjeta no válido");
		}

		/**
		 * Validar la fecha de expiración de la tarjeta.
		 */
		if (!card.getExpiration().replace("-", "").replace(".", "").replace(" ", "").replace("/", "").replace("\\", "")
				.matches("\\d+")) {
			throw new CardNotValidException("Hay caracteres en la expiración");
		}

		/**
		 * Validar el CVC de la tarjeta.
		 */
		if (!card.getCvc().matches("[0-9]+")) {
			throw new CardNotValidException("Hay caracteres en el CVC");
		}

		StringBuilder response = new StringBuilder();

		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		response.append("Creando compra a las: " + dateFormat.format(date) + "\n");

		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {
			date = new Date();
			response.append("Compra rechazada: " + dateFormat.format(date) + "\n");
			e.printStackTrace();
		}

		date = new Date();
		response.append("Compra aprobada: " + dateFormat.format(date) + "\n");

		return response.toString();
	}
}
