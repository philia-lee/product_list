package org.example.application.product.repository;

import org.example.application.product.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("이름으로 상품을 정확히 조회할 수 있다")
    void findByNameTest() {

        Product product = new Product("맥북 프로", 3000000, 5, "애플 노트북입니다.");
        productRepository.save(product);


        List<Product> result = productRepository.findByName("맥북 프로");


        assertThat(result).isNotEmpty();
        assertThat(result.get(0).getName()).isEqualTo("맥북 프로");
        assertThat(result.get(0).getPrice()).isEqualTo(3000000);
        assertThat(result.get(0).getQuantity()).isEqualTo(5);
    }

    @Test
    @DisplayName("이름에 특정 키워드가 포함된 상품들을 검색할 수 있다")
    void findByNameContainingTest() {

        Product product1 = new Product("아이폰 15", 1250000, 10, "기본형");
        Product product2 = new Product("아이폰 15 프로", 1550000, 5, "프로형");
        Product product3 = new Product("갤럭시 S24", 1150000, 20, "경쟁사 모델");


        productRepository.saveAll(List.of(product1, product2, product3));


        String keyword = "아이폰";
        List<Product> result = productRepository.findByNameContaining(keyword);


        assertThat(result).hasSize(2); // '아이폰'이 들어간 상품은 2개여야 함


        assertThat(result).extracting(Product::getName)
                .containsExactlyInAnyOrder("아이폰 15", "아이폰 15 프로");
    }
}