package com.ddev.ecom_ddev.dto.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDisplayListResponse {

    String productId;
    String productName;
    String numberOfColor;
    String numberOfSize;
    String price;
    String status;
    String image;

}
