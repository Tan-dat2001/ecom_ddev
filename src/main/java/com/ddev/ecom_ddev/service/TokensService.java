package com.ddev.ecom_ddev.service;

import com.ddev.ecom_ddev.entity.Tokens;
import com.ddev.ecom_ddev.repository.TokensRepository;
import com.ddev.ecom_ddev.repository.UsersRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TokensService {

    @Value("${security.jwt.expiration-minutes}")
    Long EXPIRATION_TIME;

    private final TokensRepository tokensRepository;
    private final UsersRepository usersRepository;

    public Tokens findByToken(String token) {
        return tokensRepository.findByAccessToken(token);
    }

    public Tokens createRefreshToken(Long userId){
//        Tokens refreshToken = Tokens.builder()
//
//                .build();
        return null;
    }


}
