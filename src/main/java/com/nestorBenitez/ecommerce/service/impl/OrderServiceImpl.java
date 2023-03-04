package com.nestorBenitez.ecommerce.service.impl;


import com.nestorBenitez.ecommerce.dto.OrderDTO;
import com.nestorBenitez.ecommerce.entity.Order;
import com.nestorBenitez.ecommerce.entity.OrderItem;
import com.nestorBenitez.ecommerce.exceptions.EntityNotFoundException;
import com.nestorBenitez.ecommerce.repository.OrderRepository;
import com.nestorBenitez.ecommerce.service.OrderService;
import com.nestorBenitez.ecommerce.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@AllArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private ProductService productService;
    @Override
    public String save(OrderDTO orderDTO) {
        Order order = new Order();
        order.setComment(orderDTO.getComment());
        List<OrderItem> items = orderDTO.getItems().stream().map(itemDTO -> {
            OrderItem item = new OrderItem();
            item.setQuantity(itemDTO.getQuantity());
            item.setProduct(productService.getProductById(itemDTO.getProductId()));
            item.setOrder(order);
            return item;
        }).toList();
        order.setItems(items);
        Order orderSaved = orderRepository.save(order);
        return orderSaved.getId().toString();
    }

    @Override
    public OrderDTO getById(UUID id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order", id));
        OrderDTO dto = new OrderDTO();
        dto.setComment(order.getComment());
        dto.setDate(order.getDate());
        dto.setState(order.getState());
        dto.setTotalPrice(orderRepository.getTotalPriceOrder(id));
        dto.setItems(orderRepository.getItemsWithTotalPrice(id));
        return dto;
    }

}
