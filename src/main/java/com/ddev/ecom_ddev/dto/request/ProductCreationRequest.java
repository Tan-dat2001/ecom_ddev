package com.ddev.ecom_ddev.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCreationRequest {

    Long id;
    String name;
    Long price;
    Long totalQuantity;
    String code;
    String brand;
    String gender;
    Long subCategoryId;
    String description;
    boolean status;
    List<String> imagesList;
    List<ProductDetailCreationRequest> productDetailCreationRequestList;

}
