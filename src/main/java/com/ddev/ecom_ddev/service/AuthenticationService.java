package com.ddev.ecom_ddev.service;

import com.ddev.ecom_ddev.dto.request.AuthenticationRequest;
import com.ddev.ecom_ddev.dto.response.ApiResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import static com.ddev.ecom_ddev.common.Message.MSG_BAD_REQUEST;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {

    AuthenticationManager authenticationManager;

    public ApiResponse<?> authenticate(AuthenticationRequest authenticationRequest){
        if(authenticationRequest.getEmail().isEmpty() || authenticationRequest.getPassword().isEmpty()){
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), MSG_BAD_REQUEST, null);
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);


    }
}
