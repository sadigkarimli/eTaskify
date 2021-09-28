package com.etaskify.app.dto;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class OrganizationSignUpDetails implements Serializable {

    private static final long serialVersionUID = -4229768915952102225L;

    @NotBlank
    private String name;

    @NotBlank
    private String phone;

    @NotBlank
    private String address;

}
