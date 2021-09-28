package com.etaskify.app.dto;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserOrganizationDetails implements Serializable {

    private static final long serialVersionUID = 535666949551948863L;

    private Long id;

    private String name;

    private String phone;

    private String address;
}
