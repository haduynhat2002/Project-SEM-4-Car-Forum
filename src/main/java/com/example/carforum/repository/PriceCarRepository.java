package com.example.carforum.repository;

 import com.example.carforum.entity.PriceCar;
 import com.example.carforum.entity.Product;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.jpa.repository.Query;
 import org.springframework.stereotype.Repository;

 import java.util.List;


@Repository
public interface PriceCarRepository extends JpaRepository<PriceCar, Integer> {
 @Query(value = "select * from PriceCar priceCar where priceCar.category_id = :id order by id DESC ", nativeQuery = true)
 List<PriceCar> listPriceCar(int id);
}
