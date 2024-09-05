package co.edu.unbosque.electroshopv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshopv2.model.Client;
import co.edu.unbosque.electroshopv2.model.OrderDTO;
import co.edu.unbosque.electroshopv2.repository.ClientRepository;
import co.edu.unbosque.electroshopv2.repository.OrderRepository;

/**
 * Servicio que gestiona la creación de pedidos en la aplicación.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ClientRepository clientRepository;

	/**
	 * Constructor por defecto de la clase OrderService.
	 */
	public OrderService() {
	}

	/**
	 * Crea un nuevo pedido basado en un objeto DTO de pedido.
	 * 
	 * Busca el cliente correspondiente en el repositorio y luego guarda el pedido
	 * en el repositorio de pedidos.
	 * 
	 * @param order Objeto @linkOrderDTO que contiene la información del pedido a
	 *              crear.
	 * @return @codetrue si el pedido se crea y guarda correctamente.
	 */
	public boolean createOrder(OrderDTO order) {
		Client client = clientRepository.findById(order.getClientDTO()).get();
		orderRepository.save(DataMapper.transformOrderDTOToOrder(order, client, order.getPaymentMethod()));
		return true;
	}
}
