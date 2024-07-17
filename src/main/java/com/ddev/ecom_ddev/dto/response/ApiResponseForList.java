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
public class ApiResponseForList<T> {
    int code;
    String message;
    Long totalItems;
    Integer totalPages;
    Integer currentPage;
    T metaData;
}
