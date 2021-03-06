package com.etaskify.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
public class UserResponse implements Serializable {

    private static final long serialVersionUID = 9154236907991232549L;

    private Long id;

    private String name;

    private String email;

    private Set<String> roles;

    private List<TaskResponse> tasks;
}
