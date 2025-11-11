package com.multicampus.gamesungcoding.a11ymarketserver.cart.repository;

import com.multicampus.gamesungcoding.a11ymarketserver.cart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, UUID> {

    List<Cart> findByUserId(UUID userId);
    Optional<Cart> findByUserIdAndProductId(UUID userId, UUID productId);

}