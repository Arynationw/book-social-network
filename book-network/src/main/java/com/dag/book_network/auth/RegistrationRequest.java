package com.dag.book_network.auth;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;



@Data
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "First name is required")
    @NotBlank(message = "First name is required")
    private String firstname;
    @NotEmpty(message = "last name is required")
    @NotBlank(message = "last name is required")
    private String lastname;
    @NotEmpty(message = "email is required")
    @NotBlank(message = "email is required")
    @Email(message = "provide a valid email")
    private String email;
    @NotEmpty(message = "password is required")
    @NotBlank(message = "password is required")
    @Size(min = 8, message = "Password is a minimum of 8 characters")
    private String password;
}
