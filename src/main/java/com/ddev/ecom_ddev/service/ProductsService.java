package com.ddev.ecom_ddev.service;

import com.ddev.ecom_ddev.dto.request.ProductCreationRequest;
import com.ddev.ecom_ddev.dto.response.ApiResponse;
import com.ddev.ecom_ddev.dto.response.ApiResponseForList;
import com.ddev.ecom_ddev.entity.Products;
import com.ddev.ecom_ddev.mapper.ProductMapper;
import com.ddev.ecom_ddev.repository.ProductsRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;



import static com.ddev.ecom_ddev.common.Message.*;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
@Slf4j
public class ProductsService implements IProductsService{

    ProductsRepository productsRepository;
    private final ProductMapper productMapper;

    //    public ApiResponse<?> getProductDisplayList(Integer limit) {
//        if(limit != null && limit > 0){
//            Optional<List<Products>> productsListOptional = productsRepository.getProductDisplayList(limit);
//            if(productsListOptional.isPresent()){
//                List<Products> productsList = productsListOptional.get();
//                int totalItems = productsList.size();
//            return new ApiResponseForList<>(HttpStatus.OK.value(),MSG_GET_PRODUCT_DISPLAY_LIST_SUCCESS, totalItems, )
//
//            }
//        }
//        return new ApiResponse<>()
//    }
    public ApiResponseForList<?> getProductDisplayList(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Products> allProducts = productsRepository.getProductDisplayList(pageable);
        return new ApiResponseForList<>(HttpStatus.OK.value(), MSG_GET_PRODUCT_DISPLAY_LIST_SUCCESS, allProducts.getTotalElements(), allProducts.getTotalPages(), allProducts.getNumber(), allProducts.getContent());
    }

    public ApiResponse<?> createProduct(ProductCreationRequest productCreationRequest) {
        if(productCreationRequest == null && productCreationRequest.getSubCategoryId().toString().isEmpty()){
            return new  ApiResponse<>(HttpStatus.BAD_REQUEST.value(), MSG_DATA_NULL, null );
        }
        if(productsRepository.existsByName(productCreationRequest.getName())){
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), MSG_NAME_PRODUCT_EXIST, null);
        }

        Products products = productMapper.toProducts(productCreationRequest);

        return new ApiResponse<>(HttpStatus.OK.value(),"SUCCESS", products);
    }
}
