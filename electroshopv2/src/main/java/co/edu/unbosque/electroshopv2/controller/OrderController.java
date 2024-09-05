package co.edu.unbosque.electroshopv2.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.electroshopv2.model.RequestOrderDTO;
import co.edu.unbosque.electroshopv2.service.CardService;
import co.edu.unbosque.electroshopv2.service.OrderDetailService;
import co.edu.unbosque.electroshopv2.service.OrderService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Controlador REST para la gestión de pedidos en la aplicación Electroshop.
 * 
 * Esta clase se encarga de manejar las solicitudes relacionadas con los pedidos, 
 * como la creación y procesamiento de los mismos. Utiliza varias capas de servicios 
 * para llevar a cabo las operaciones necesarias.
 * 
 * La anotación @RestController indica que esta clase es un controlador 
 * que devuelve datos directamente como respuestas JSON. Además, se utiliza 
 * @RequestMapping para definir la URL base del controlador.
 * 
 * La anotación @CrossOrigin(origins = "*") permite que la API acepte solicitudes 
 * desde cualquier origen.
 * 
 * El uso de @Transactional asegura que todas las operaciones dentro de 
 * los métodos del controlador se ejecuten dentro de una transacción, lo que significa 
 * que si ocurre un error, todas las acciones realizadas dentro de esa transacción 
 * serán revertidas.
 * 
 * Este controlador depende de tres servicios principales: OrderService, 
 * CardService, y OrderDetailService, los cuales se inyectan 
 * utilizando la anotación @Autowired.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@Tag(name = "Pedidos", description = "Operaciones relacionadas con los pedidos")
@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "*")
@Transactional
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CardService cardService;

    @Autowired
    private OrderDetailService orderDetailService;

    /**
     * Constructor de la clase OrderController.
     */
    public OrderController() {
        // Constructor vacío
    }

    /**
     * Método para procesar un pedido.
     * 
     * Este método maneja las solicitudes POST en la URL /api/pedidos/procesar. 
     * Se encarga de crear un pedido, validar la tarjeta de crédito y agregar los detalles 
     * del pedido.
     * 
     * Recibe como parámetro un objeto RequestOrderDTO que contiene la 
     * información del pedido, la tarjeta de crédito y los detalles del pedido.
     * 
     * Si el pedido se crea correctamente, devuelve un mensaje de éxito. En caso contrario, 
     * devuelve un mensaje de error.
     * 
     * @param requestOrderDTO Objeto que contiene la información del pedido, tarjeta y detalles.
     * @return ResponseEntity con el resultado del procesamiento del pedido.
     */
    @Operation(summary = "Procesar un pedido", description = "Crea un pedido, valida la tarjeta y agrega los detalles del pedido.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pedido procesado con éxito", 
                     content = { @Content(mediaType = "application/json", 
                     schema = @Schema(implementation = String.class)) }),
        @ApiResponse(responseCode = "400", description = "Solicitud no válida", content = @Content),
        @ApiResponse(responseCode = "402", description = "Tarjeta no válida", content = @Content),
        @ApiResponse(responseCode = "500", description = "Error en el servidor", content = @Content)
    })
    @PostMapping("/procesar")
    public ResponseEntity<?> processAnOrder(@Valid @RequestBody RequestOrderDTO requestOrderDTO) {
        StringBuilder serverResponse = new StringBuilder();
        if (orderService.createOrder(requestOrderDTO.getOrderDTO())) {
            serverResponse.append("Pedido creado con éxito...\n");
        } else {
            serverResponse.append("Error creando el pedido...\n");
        }

        serverResponse.append(cardService.validateCard(requestOrderDTO.getCardDTO()) + "\n");

        serverResponse.append(orderDetailService.addDetails(requestOrderDTO.getOrderDetails()) + "\n");

        return ResponseEntity.ok(serverResponse.toString());
    }
}
