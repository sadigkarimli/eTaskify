package com.etaskify.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class TaskResponse implements Serializable {

    private static final long serialVersionUID = 6515015713279293923L;

    private Long id;

    private String title;

    private LocalDateTime deadline;

    @JsonProperty("assignees")
    List<TaskAssigneeUserDetails> assigneeUsers;

    private String status;
}
