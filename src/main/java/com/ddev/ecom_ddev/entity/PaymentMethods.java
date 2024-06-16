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
public class PaymentMethods {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    boolean status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL)
    List<Orders> ordersList;
}
