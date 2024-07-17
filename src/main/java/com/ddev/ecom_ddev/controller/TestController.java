package com.ddev.ecom_ddev.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public String test() {
        return "HELLO";
    }
}
