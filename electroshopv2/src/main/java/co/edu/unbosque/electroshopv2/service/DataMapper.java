package co.edu.unbosque.electroshopv2.service;

import co.edu.unbosque.electroshopv2.model.Client;
import co.edu.unbosque.electroshopv2.model.EmbeddedIdOrderDetail;
import co.edu.unbosque.electroshopv2.model.Order;
import co.edu.unbosque.electroshopv2.model.OrderDTO;
import co.edu.unbosque.electroshopv2.model.OrderDetail;
import co.edu.unbosque.electroshopv2.model.OrderDetailDTO;
import co.edu.unbosque.electroshopv2.model.PaymentMethod;
import co.edu.unbosque.electroshopv2.model.Product;

/**
 * Clase de utilidad para mapear datos entre objetos DTO y entidades del modelo.
 * 
 * Proporciona métodos estáticos para convertir objetos de transferencia de datos (DTO) en entidades del modelo.
 * 
 * @author Andres Felipe Espitia Rodriguez
 * @author Johan Sebastian Gomez Beltran
 * @author Kevin David Peña Bustos
 * @author David Esteban López Castillo
 * @version 2.0
 */
public class DataMapper {	

    /**
     * Convierte un objeto @linkOrderDTO en una entidad @linkOrder.
     * 
     * @param orderDTO Objeto DTO que contiene la información del pedido.
     * @param client Cliente asociado al pedido.
     * @param paymentMethod Método de pago utilizado para el pedido.
     * @return Entidad {@link Order} creada a partir del DTO proporcionado.
     */
    public static Order transformOrderDTOToOrder(OrderDTO orderDTO, Client client, PaymentMethod paymentMethod) {
        Order order = new Order();
        order.setOrderId(orderDTO.getOrderId());
        order.setClient(client);
        order.setPaymentMethod(paymentMethod);
        order.setTotalValue(orderDTO.getTotalValue());
        return order;
    }
    
    /**
     * Convierte un objeto @linkOrderDetailDTO en una entidad @linkOrderDetail.
     * 
     * @param orderDetailDTO Objeto DTO que contiene la información del detalle del pedido.
     * @param order Pedido al que pertenece el detalle.
     * @param product Producto asociado al detalle del pedido.
     * @return Entidad {@link OrderDetail} creada a partir del DTO proporcionado.
     */
    public static OrderDetail transformOrderDetailDTOToOrderDetail(OrderDetailDTO orderDetailDTO, Order order, Product product) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderDetailId(new EmbeddedIdOrderDetail());
        orderDetail.getOrderDetailId().setOrder(order);
        orderDetail.getOrderDetailId().setProduct(product);
        orderDetail.setQuantity(orderDetailDTO.getQuantity());
        return orderDetail;
    }

}
