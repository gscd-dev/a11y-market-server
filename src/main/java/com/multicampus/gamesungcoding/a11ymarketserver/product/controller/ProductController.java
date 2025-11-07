package com.multicampus.gamesungcoding.a11ymarketserver.product.controller;

import com.multicampus.gamesungcoding.a11ymarketserver.product.model.ProductDTO;
import com.multicampus.gamesungcoding.a11ymarketserver.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * [ProductController]
 * - 상품 목록 조회 API
 * - GET /api/v1/products
 */
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * 상품 전체 목록 조회
     *
     * @return 상품 목록(JSON 배열)
     */
    @GetMapping("/v1/products")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }
}

