package com.ddev.ecom_ddev.service;

import com.ddev.ecom_ddev.dto.request.ProductCreationRequest;
import com.ddev.ecom_ddev.dto.response.ApiResponse;
import com.ddev.ecom_ddev.dto.response.ApiResponseForList;

public interface IProductsService {

    ApiResponse<?> createProduct(ProductCreationRequest productCreationRequest);

    ApiResponseForList<?> getProductDisplayList(Integer page, Integer size);
}
