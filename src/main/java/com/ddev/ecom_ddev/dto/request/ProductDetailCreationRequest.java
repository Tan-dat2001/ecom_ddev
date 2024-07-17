package com.ddev.ecom_ddev.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDetailCreationRequest {

    String size;
    String color;
    String quantity;

}
