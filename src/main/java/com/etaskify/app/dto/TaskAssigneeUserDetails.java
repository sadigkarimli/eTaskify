package com.etaskify.app.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
public class TaskAssigneeUserDetails implements Serializable {

    private static final long serialVersionUID = -3940698014986536207L;

    private Long id;

    private String name;

    private String email;

    private Set<Long> userTaskIds;
}
