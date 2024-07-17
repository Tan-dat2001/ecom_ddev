package com.ddev.ecom_ddev.repository;

import com.ddev.ecom_ddev.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductsRepository extends JpaRepository<Products, Long> {

    @Query(value = "select * from products where status = true order by created_at desc", nativeQuery = true)
    Page<Products> getProductDisplayList(Pageable pageable);

    boolean existsByName(String name);
}
