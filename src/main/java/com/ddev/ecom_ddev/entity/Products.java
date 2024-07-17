package com.ddev.ecom_ddev.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Long price;
    Long soldQuantity;
    Long inventoryQuantity;
    String code;
    String brand;
    String gender;
    String description;
    boolean status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "subCategory_id")
    SubCategories subCategory;

    @OneToMany( mappedBy = "product", cascade = CascadeType.ALL)
    List<ProductDetails> productDetailsList;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<ProductImages> productImagesList;



}
