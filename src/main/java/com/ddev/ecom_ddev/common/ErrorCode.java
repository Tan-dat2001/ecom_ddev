package com.ddev.ecom_ddev.common;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import static com.ddev.ecom_ddev.common.Message.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ErrorCode {
    REQUEST_NULL_DATA(400, MSG_BAD_REQUEST, HttpStatus.BAD_REQUEST),
    INCORRECT_PASSWORD(401, MSG_INCORRECT_PASWORD, HttpStatus.BAD_REQUEST),
    EMAIL_NOT_REGISTER(403, MSG_EMAIL_NOT_REGISTER, HttpStatus.BAD_REQUEST),
    EMAIL_EXIST(403, MSG_EMAIL_EXIST, HttpStatus.BAD_REQUEST),
    ;
    private Integer code;
    private String message;
    private HttpStatus statusCode;

}
