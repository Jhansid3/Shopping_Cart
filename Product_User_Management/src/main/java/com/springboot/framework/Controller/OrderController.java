package com.springboot.framework.Controller;

import com.springboot.framework.Entity.Order;
import com.springboot.framework.Repository.OrderRepository;
import com.springboot.framework.Requests.OrderDTO;
import com.springboot.framework.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;



    @GetMapping("/{id}")
        public Order getOrderById(@PathVariable ("id") Integer order_id){
            return orderService.getOrderBYID(order_id);
        }

    @PostMapping
    public Order createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }
}

