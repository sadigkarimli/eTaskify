package com.etaskify.app.model;

import org.springframework.stereotype.Component;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Component
@Converter(autoApply = true)
public class TaskStatusConverter implements AttributeConverter<TaskStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(TaskStatus taskStatus) {
        if (taskStatus == null) {
            return null;
        }
        return taskStatus.getId();
    }

    @Override
    public TaskStatus convertToEntityAttribute(Integer id) {
        if (id == null) {
            return null;
        }
        return Stream.of(TaskStatus.values())
                .filter(status -> status.getId().equals(id))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Not found a matched task status by id"));
    }
}
