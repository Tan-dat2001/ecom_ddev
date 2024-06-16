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
public class OrderStatuses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @OneToMany(mappedBy = "orderStatus", cascade = CascadeType.ALL)
    List<Orders> ordersList;
}
