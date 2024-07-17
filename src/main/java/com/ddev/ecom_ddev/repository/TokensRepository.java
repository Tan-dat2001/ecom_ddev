package com.ddev.ecom_ddev.repository;

import com.ddev.ecom_ddev.entity.Tokens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TokensRepository extends JpaRepository<Tokens, Long> {

    Tokens findByAccessToken(String accessToken);
}
