package com.multicampus.gamesungcoding.a11ymarketserver.feature.order.repository;

import com.multicampus.gamesungcoding.a11ymarketserver.feature.order.entity.OrderItemStatus;
import com.multicampus.gamesungcoding.a11ymarketserver.feature.order.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderItemsRepository extends JpaRepository<OrderItems, UUID> {

    List<OrderItems> findByProductIdIn(List<UUID> productIds);

    List<OrderItems> findByProductIdInAndOrderItemStatus(List<UUID> productIds, OrderItemStatus status);
}
