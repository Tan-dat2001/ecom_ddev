package com.ddev.ecom_ddev.mapper;

import com.ddev.ecom_ddev.dto.request.ProductCreationRequest;
import com.ddev.ecom_ddev.dto.request.ProductDetailCreationRequest;
import com.ddev.ecom_ddev.entity.Products;
import com.ddev.ecom_ddev.entity.SubCategories;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "subCategory",source = "subCategoryId", qualifiedByName = "mapSubCategory")
    Products toProducts(ProductCreationRequest productCreationRequest);
    @Named("mapSubCategory")
    default SubCategories mapSubCategory(Long subCategoryId) {
        if (subCategoryId == null) {
            return null;
        }
        SubCategories subCategory = new SubCategories();
        subCategory.setId(subCategoryId);
        return subCategory;
    }


    @Mapping(target = "id", ignore = true)
    ProductCreationRequest createProductDTOWithoutId(Products products);

}
