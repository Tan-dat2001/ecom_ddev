package com.ddev.ecom_ddev.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductResponse {

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
    Long subCategoryId;

}
