package com.ddev.ecom_ddev.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long priceItem;
    Long quantity;

    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "product_detail_id")
    ProductDetails productDetail;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    Carts cart;


}
