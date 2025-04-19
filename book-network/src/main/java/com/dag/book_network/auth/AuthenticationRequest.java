package com.dag.book_network.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationRequest {

    @NotEmpty(message = "email is required")
    @NotBlank(message = "email is required")
    @Email(message = "provide a valid email")
    private String email;
    @NotEmpty(message = "password is required")
    @NotBlank(message = "password is required")
    private String password;
}
