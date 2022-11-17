package com.example.carforum.repository;

import com.example.carforum.entity.Post;
import com.example.carforum.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from Products products where products.dealer_id = :id order by id DESC ", nativeQuery = true)
    List<Product> listProduct(int id);
}
