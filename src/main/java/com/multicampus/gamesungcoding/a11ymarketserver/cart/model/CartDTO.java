package com.multicampus.gamesungcoding.a11ymarketserver.cart.model;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDTO {

    private UUID cartItemId;
    private UUID cartId;
    private UUID productId;
    private Integer quantity;

}