package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository đã có sẵn các hàm CRUD cơ bản như:
    // findAll(), findById(), save(), delete()

    // Bạn có thể định nghĩa thêm các hàm tìm kiếm tùy chỉnh tại đây, ví dụ:
    // Tìm sản phẩm theo tên
    List<Product> findByNameContaining(String keyword);

    // Tìm sản phẩm có giá thấp hơn X
    List<Product> findByPriceLessThan(Double price);
}