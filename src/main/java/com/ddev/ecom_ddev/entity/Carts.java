package com.ddev.ecom_ddev.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Carts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    // quantity item in cart
    Long quantityItem;
    @OneToOne
    @JoinColumn(name = "user_id")
    Users user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    List<CartItems> cartItemsList;


}
