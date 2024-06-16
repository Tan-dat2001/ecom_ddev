package com.ddev.ecom_ddev.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String size;
    String color;
    Long quantity;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Products product;

    @OneToMany(mappedBy = "productDetail", cascade = CascadeType.ALL)
    List<OrderDetails> orderDetailsList;

    @OneToMany(mappedBy = "productDetail", cascade = CascadeType.ALL)
    List<CartItems> cartItemsList;
}
