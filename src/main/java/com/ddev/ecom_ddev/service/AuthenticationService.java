package com.ddev.ecom_ddev.service;

import com.ddev.ecom_ddev.config.Jwt.JwtService;
import com.ddev.ecom_ddev.config.userServiceSecurity.UserDetailsImpl;
import com.ddev.ecom_ddev.dto.request.AuthenticationRequest;
import com.ddev.ecom_ddev.dto.request.UserCreationRequest;
import com.ddev.ecom_ddev.dto.response.ApiResponse;
import com.ddev.ecom_ddev.dto.response.AuthenticationResponse;
import com.ddev.ecom_ddev.entity.Roles;
import com.ddev.ecom_ddev.entity.Users;
import com.ddev.ecom_ddev.repository.RoleRepository;
import com.ddev.ecom_ddev.repository.UsersRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static com.ddev.ecom_ddev.common.Message.*;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationService {

    UsersRepository usersRepository;
    AuthenticationManager authenticationManager;
    JwtService jwtService;
    PasswordEncoder passwordEncoder;
    RoleRepository roleRepository;

    public ApiResponse<?> register(UserCreationRequest userCreationRequest){
        if(usersRepository.existsByEmail(userCreationRequest.getEmail())){
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), MSG_EMAIL_EXIST, null);
        }

        Roles role = roleRepository.findByName("USER").get();

        Users user = Users.builder()
                .email(userCreationRequest.getEmail())
                .password(passwordEncoder.encode(userCreationRequest.getPassword()))
                .firstName(userCreationRequest.getFirstName())
                .lastName(userCreationRequest.getLastName())
                .phone(userCreationRequest.getPhone())
                .birthDate(userCreationRequest.getBirthDate())
                .role(role)
                .status(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        usersRepository.save(user);

        return new ApiResponse<>(HttpStatus.OK.value(),MSG_REGISTRY_SUCCESS, null );
    }

    public ApiResponse<?> authenticate(AuthenticationRequest authenticationRequest){
        if(authenticationRequest.getEmail().isEmpty() || authenticationRequest.getPassword().isEmpty()){
            return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), MSG_BAD_REQUEST, null);
        }

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        Users user = usersRepository.findByEmail(authenticationRequest.getEmail()).get();

        String jwt = jwtService.generateToken(user, generateExtraClaims(user));

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
                .userId(user.getId().toString())
                .email(userDetails.getUsername())
                .role(userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(", ")))
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .phone(user.getPhone())
                .authenticated(true)
                .token(jwt)
                .build();
        return new ApiResponse<>(HttpStatus.OK.value(), MSG_LOGIN_SUCCESS, authenticationResponse);
    }

    private Map<String, Object> generateExtraClaims(Users user) {

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("email", user.getEmail());
        extraClaims.put("role", user.getRole().getName());

        return extraClaims;
    }
}
