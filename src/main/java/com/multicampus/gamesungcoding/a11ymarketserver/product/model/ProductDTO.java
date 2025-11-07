package com.multicampus.gamesungcoding.a11ymarketserver.product.model;

import lombok.*;

/**
 * [ProductDTO]
 * - 클라이언트 응답용 데이터 전송 객체
 * - 목록 조회에 필요한 최소 필드만 포함
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

    private String id;
    private String name;
    private String category;
    private Integer price;
    private String status;

    /**
     * 엔티티를 DTO로 변환하는 정적 메서드
     */
    public static ProductDTO from(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .price(product.getPrice())
                .status(product.getStatus())
                .build();
    }
}
