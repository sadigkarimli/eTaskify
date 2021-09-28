package com.etaskify.app.dto;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.Data;

import java.io.Serializable;

@Data
public class TaskAssigneeUserDetails implements Serializable {

    private static final long serialVersionUID = -3940698014986536207L;

    private Long id;

    private String name;

    private String email;
}
