package com.nestorBenitez.ecommerce.repository;

import com.nestorBenitez.ecommerce.dto.OrderItemDTO;
import com.nestorBenitez.ecommerce.entity.Order;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

  @Query("SELECT SUM(p.price * oi.quantity) "
      + "FROM Order o "
      + "JOIN o.items oi "
      + "JOIN oi.product p "
      + "WHERE o.id = ?1")
  Double getTotalPriceOrder(UUID orderId);

  @Query(
      "SELECT new com.nestorBenitez.ecommerce.dto.OrderItemDTO(p.id, oi.quantity, oi.quantity * p.price) "
          + "FROM Order o "
          + "JOIN o.items oi "
          + "JOIN oi.product p "
          + "WHERE o.id = ?1")
  List<OrderItemDTO> getItemsWithTotalPrice(UUID orderId);
}
