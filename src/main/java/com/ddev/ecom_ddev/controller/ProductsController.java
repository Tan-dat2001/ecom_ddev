package com.ddev.ecom_ddev.controller;

import com.ddev.ecom_ddev.dto.request.ProductCreationRequest;
import com.ddev.ecom_ddev.dto.response.ApiResponse;
import com.ddev.ecom_ddev.dto.response.ApiResponseForList;
import com.ddev.ecom_ddev.service.ProductsService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductsController {

    ProductsService productsService;

    @GetMapping
    public ApiResponseForList<?> getProductList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size){
        return productsService.getProductDisplayList(page, size);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ApiResponse<?> createProduct(@RequestBody ProductCreationRequest productCreationRequest){
        return productsService.createProduct(productCreationRequest);
    }
}
