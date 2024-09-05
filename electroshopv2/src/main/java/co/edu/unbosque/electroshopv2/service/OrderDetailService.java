package co.edu.unbosque.electroshopv2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.electroshopv2.exception.NoEnoughStockException;
import co.edu.unbosque.electroshopv2.model.Order;
import co.edu.unbosque.electroshopv2.model.OrderDetailDTO;
import co.edu.unbosque.electroshopv2.model.Product;
import co.edu.unbosque.electroshopv2.repository.OrderDetailRepository;
import co.edu.unbosque.electroshopv2.repository.OrderRepository;
import co.edu.unbosque.electroshopv2.repository.ProductRepository;
import co.edu.unbosque.electroshopv2.repository.StockRepository;

/**
 * Servicio que gestiona la creación y adición de detalles a los pedidos.}
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    
    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private StockRepository stockRepository;
    
    /**
     * Constructor por defecto de la clase OrderDetailService.
     */
    public OrderDetailService() {
    }

    /**
     * Crea un detalle de pedido para un producto específico.
     * 
     * Verifica que haya suficiente stock disponible antes de crear el detalle.
     * Si no hay suficiente stock, lanza una excepción @linkNoEnoughStockException.
     * 
     * @param orderDetail DTO que contiene la información del detalle del pedido.
     * @return {@code true} si el detalle del pedido se crea con éxito.
     * @throws NoEnoughStockException Si no hay suficiente stock para el producto solicitado.
     */
    public boolean createOrderDetail(OrderDetailDTO orderDetail) {
        List<Order> orders = (List<Order>) orderRepository.findAll();
        Order order = orders.get(orders.size() - 1);  // Obtiene el último pedido
        Product product = productRepository.findById(orderDetail.getProduct()).get();
        
        if(stockRepository.findById(orderDetail.getProduct()).get().getStock() < orderDetail.getQuantity()) {
            throw new NoEnoughStockException("No hay suficientes " + stockRepository.findById(orderDetail.getProduct()).get().getProduct().getName());
        }
        
        stockRepository.findById(orderDetail.getProduct()).get().setStock(stockRepository.findById(orderDetail.getProduct()).get().getStock() - orderDetail.getQuantity());
        
        orderDetailRepository.save(DataMapper.transformOrderDetailDTOToOrderDetail(orderDetail, order, product));
        return true;
    }

    /**
     * Añade una lista de detalles de pedido a un pedido existente.
     * 
     * @param orderDetails Lista de detalles de pedido a añadir.
     * @return Un mensaje indicando cuántos detalles fueron agregados exitosamente.
     */
    public String addDetails(List<OrderDetailDTO> orderDetails) {
        for(OrderDetailDTO od : orderDetails) {
            createOrderDetail(od);
        }
        return orderDetails.size() + " detalles agregados con éxito";
    }
    
}
