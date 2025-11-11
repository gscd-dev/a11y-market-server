package com.multicampus.gamesungcoding.a11ymarketserver.cart.service;


import com.multicampus.gamesungcoding.a11ymarketserver.cart.model.Cart;
import com.multicampus.gamesungcoding.a11ymarketserver.cart.model.CartDTO;
import com.multicampus.gamesungcoding.a11ymarketserver.cart.model.CartAddRequest;
import com.multicampus.gamesungcoding.a11ymarketserver.cart.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    @Override
    public List<CartDTO> getCartItems(UUID userId) {
        return cartRepository.findByUserId(userId).stream()
                .map(Cart::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public int getCartTotal(UUID userId) {
        // 현재 cart_items에 price가 없으므로 총액은 이 단계에서 계산 불가.
        // TODO: product 가격 조인 후 합산 (ex. productRepository로 가격 조회해서 계산)
        return 0;
    }

    @Override
    @Transactional
    public CartDTO addItem(CartAddRequest req) {
        Cart cart = cartRepository.findByUserIdAndProductId(req.getUserId(), req.getProductId())
                .map(existing -> {
                    existing.increaseQuantity(req.getQuantity());
                    return existing;
                })
                .orElseGet(() -> Cart.builder()
                        .userId(req.getUserId())
                        .productId(req.getProductId())
                        .quantity(req.getQuantity())
                        .build()
                );
        return cartRepository.save(cart).toDto();
    }

    @Override
    @Transactional
    public CartDTO updateQuantity(UUID cartItemId, int quantity) {

        Cart cart = cartRepository.findById(cartItemId)
                .orElseThrow(() -> new NoSuchElementException("Cart item not found: " + cartItemId));

        cart.changeQuantity(quantity);
        return cart.toDto();
    }

    @Override
    @Transactional
    public void deleteItems(List<UUID> itemIds) {
        cartRepository.deleteAllByIdInBatch(itemIds);
    }
}