package com.etaskify.app.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "task")
public class Task implements Serializable {

    private static final long serialVersionUID = -3486979426984567790L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDateTime deadline;

    private TaskStatus status;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Organization organization;

    @ManyToMany(mappedBy = "tasks")
    private Set<User> users = new HashSet<>();
}
