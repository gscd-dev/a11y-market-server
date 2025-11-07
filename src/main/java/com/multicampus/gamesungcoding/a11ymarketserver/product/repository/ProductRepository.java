package com.multicampus.gamesungcoding.a11ymarketserver.product.repository;

import com.multicampus.gamesungcoding.a11ymarketserver.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * [ProductRepository]
 * - 상품 목록 조회 기능만 담당
 * - createdAt 내림차순 정렬로 전체 상품 반환
 */
public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findAllByOrderByCreatedAtDesc();
}

