package com.nestorBenitez.ecommerce.service;


import com.nestorBenitez.ecommerce.dto.OrderDTO;

import java.util.UUID;

public interface OrderService {
    String save(OrderDTO orderDTO);
    OrderDTO getById(UUID id);
}
