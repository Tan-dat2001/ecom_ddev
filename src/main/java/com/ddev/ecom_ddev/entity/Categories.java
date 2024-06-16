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
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String description;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<SubCategories> subCategoriesList;
}
