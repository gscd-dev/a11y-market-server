package com.multicampus.gamesungcoding.a11ymarketserver.product.service;

import com.multicampus.gamesungcoding.a11ymarketserver.product.model.Product;
import com.multicampus.gamesungcoding.a11ymarketserver.product.model.ProductDTO;
import com.multicampus.gamesungcoding.a11ymarketserver.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * [ProductServiceImpl]
 * - 상품 목록 조회 기능 구현
 * - Repository 호출 후 DTO 변환
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAllByOrderByCreatedAtDesc();
        return products.stream()
                .map(ProductDTO::from)
                .collect(Collectors.toList());
    }
}
