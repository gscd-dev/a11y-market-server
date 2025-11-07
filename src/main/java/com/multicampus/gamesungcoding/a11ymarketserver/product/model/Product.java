package com.multicampus.gamesungcoding.a11ymarketserver.product.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * [Product 엔티티]
 * - DB의 'products' 테이블과 매핑
 * - Lombok 기반 코드로 단순화
 * - 상품 목록 조회에 필요한 필드만 포함
 */
@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    /**
     * 상품 고유 ID (UUID 기반)
     */
    @Id
    private String id;

    /**
     * 상품명
     */
    private String name;

    /**
     * 카테고리명
     */
    private String category;

    /**
     * 상품 가격
     */
    private Integer price;

    /**
     * 상품 상태 (판매중, 품절 등)
     */
    private String status;

    /**
     * 등록일시
     */
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    /**
     * 엔티티 저장 전 ID 및 생성일시 자동 설정
     */
    @PrePersist
    public void prePersist() {
        if (this.id == null) {
            this.id = "PROD-" + UUID.randomUUID();
        }
        this.createdAt = LocalDateTime.now();
    }
}
