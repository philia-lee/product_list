package org.example.application.product.controller;

import org.example.application.product.dto.ProductResponse;
import org.example.application.product.entity.Product;
import org.example.application.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //전체 상품조회
    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.findAllProducts();
    }
    @GetMapping("/{id}")
    public ProductResponse getProductById(@PathVariable Long id) {
        return productService.findProductById(id);
    }
    @GetMapping("/search")
    public List<ProductResponse> searchProducts(@RequestParam String name) {
        return productService.searchProductsByName(name);
    }


}
