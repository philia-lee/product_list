package org.example.application.product.service;

import org.example.application.product.dto.ProductResponse;
import org.example.application.product.entity.Product;
import org.example.application.product.repository.ProductRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;

    // 생성자 주입
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    //상품 전체 조회

//    @Cacheable(value = "productList", sync = true)
    public List<ProductResponse> findAllProducts() {
        return productRepository.findAll().stream()
                .map(ProductResponse::from)
                .toList();
    }
    //id로 삼품 조회
    public ProductResponse findProductById(Long id) {
        return productRepository.findById(id)
                .map(ProductResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품이 없습니다"));
    }
    //상품 이름으로 정확히 조회
    public List<ProductResponse> findProductsByName(String name) {
        return productRepository.findByName(name).stream()
                .map(ProductResponse::from)
                .toList();
    }

    // 상품 이름에 특정 키워드가 포함된 목록 검색
    public List<ProductResponse> searchProductsByName(String name) {
        return productRepository.findByNameContaining(name).stream()
                .map(ProductResponse::from)
                .toList();

    }



}
