package com.etaskify.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class AuthRequest implements Serializable {

    private static final long serialVersionUID = 9055780225741114361L;

    @NotBlank
    @Email
    @JsonProperty("email")
    private String email;

    @NotBlank
    @Size(min = 6)
    @JsonProperty("password")
    private String password;
}
