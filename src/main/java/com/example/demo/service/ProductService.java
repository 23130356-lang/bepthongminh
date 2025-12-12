package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productDao; // Tiêm (Inject) DAO vào Service

    // Hàm lấy tất cả sản phẩm
    public List<Product> getAllProducts() {
        return productDao.findAll(); // Gọi hàm của DAO
    }

    // Hàm lưu sản phẩm
    public void saveProduct(Product product) {
        productDao.save(product);
    }
}