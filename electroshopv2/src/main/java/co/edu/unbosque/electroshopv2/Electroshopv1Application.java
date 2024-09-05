package co.edu.unbosque.electroshopv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot para la API de Electroshop.
 * 
 * Esta clase contiene el método main que es el punto de entrada para ejecutar
 * la aplicación usando Spring Boot. Al ejecutarse, se inicializa el contexto de
 * la aplicación Spring y se configura automáticamente todos los componentes,
 * controladores y servicios según las configuraciones predeterminadas y
 * personalizadas.
 * 
 * @SpringBootApplication simplifica la configuración de la aplicación.
 * 
 * 
 */

@SpringBootApplication
public class Electroshopv1Application {

	public static void main(String[] args) {
		SpringApplication.run(Electroshopv1Application.class, args);
	}

}
