package com.etaskify.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Accessors(chain = true)
public class SignUpRequest implements Serializable {

    private static final long serialVersionUID = -2293896135175659749L;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6)
    private String password;

    @NotNull
    @JsonProperty("org")
    private OrganizationSignUpDetails organization;
}
