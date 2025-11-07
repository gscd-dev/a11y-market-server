package com.multicampus.gamesungcoding.a11ymarketserver.product.service;

import com.multicampus.gamesungcoding.a11ymarketserver.product.model.ProductDTO;

import java.util.List;

/**
 * [ProductService]
 * - 상품 목록 조회 기능 정의
 */
public interface ProductService {

    /**
     * 상품 전체 목록 조회
     *
     * @return 상품 DTO 리스트
     */
    List<ProductDTO> getAllProducts();
}
