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
    String description;
    Long price;
    Long soldQuantity;
    Long inventoryQuantity;
    boolean status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "subCategory_id")
    SubCategories subCategory;

    @OneToMany( mappedBy = "product",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ProductDetails> productDetailsList;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<ProductImages> productImagesList;



}
