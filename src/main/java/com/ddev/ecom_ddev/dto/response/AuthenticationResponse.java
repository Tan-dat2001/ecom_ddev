package com.ddev.ecom_ddev.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationResponse {

    String email;
    String role;
    String userId;
    String firstName;
    String lastName;
    String phone;
    boolean authenticated;
    String token;

}
