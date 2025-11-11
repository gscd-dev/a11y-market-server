package com.multicampus.gamesungcoding.a11ymarketserver.cart.service;

import com.multicampus.gamesungcoding.a11ymarketserver.cart.model.CartDTO;
import com.multicampus.gamesungcoding.a11ymarketserver.cart.model.CartAddRequest;
import java.util.UUID;
import java.util.List;

public interface CartService {
    // 조회
    List<CartDTO> getCartItems(UUID userId);
    int getCartTotal(UUID userId);

    // 추가
    CartDTO addItem(CartAddRequest req);

    // 수량 수정
    CartDTO updateQuantity(UUID cartItemId, int quantity);

    // 삭제
    void deleteItems(List<UUID> itemIds);
}