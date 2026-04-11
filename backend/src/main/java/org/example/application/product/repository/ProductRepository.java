package org.example.application.product.repository;

import org.example.application.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    //이름으로 조회
    List<Product> findByName(String name);
    //이름으로 검색
    List<Product> findByNameContaining(String keyword);

}
