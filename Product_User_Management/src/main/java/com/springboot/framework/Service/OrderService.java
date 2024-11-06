package com.springboot.framework.Service;

import com.springboot.framework.Entity.Order;
import com.springboot.framework.Entity.Product;
import com.springboot.framework.Entity.User;
import com.springboot.framework.Repository.OrderRepository;
import com.springboot.framework.Repository.ProductRepository;
import com.springboot.framework.Repository.UserRepository;
import com.springboot.framework.Requests.OrderDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    public static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public Order getOrderBYID(Integer order_id) {
        Optional<Order> optionalOrder = orderRepository.findById(order_id);
        if (optionalOrder.isPresent()) {
            return optionalOrder.get();
        } else {
            return null;
        }
    }

    public Order createOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setUser(userRepository.getById(orderDTO.getUser_id()));
        order.setProduct(productRepository.getById(orderDTO.getProduct_id()));
        order.setQuantity(orderDTO.getQuantity());
        order.setOrder_date(orderDTO.getOrder_date());
        order.setTotal_amount(orderDTO.getTotal_amount());
        logger.info("Order is created {} ",order);
        return orderRepository.save(order);
    }
}
//
//    public void deleteOrder(int order_id){
//
//    }

