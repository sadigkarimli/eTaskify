package com.etaskify.app.dto;

import com.etaskify.app.model.RoleName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class UserResponse implements Serializable {

    private static final long serialVersionUID = -8111829699048509978L;

    private Long id;

    private String name;

    private String email;

    private Set<String> roles;

    @JsonProperty("organization")
    private UserOrganizationDetails organizationDetails;
}
