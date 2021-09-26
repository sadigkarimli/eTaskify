package com.etaskify.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TaskStatus {
    DELETED(0),
    TO_DO (1),
    IN_PROGRESS(2),
    COMPLETE(3);

    private final Integer id;
}
