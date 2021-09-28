package com.etaskify.app.event;

import org.springframework.context.ApplicationEvent;

public class TaskAssignedEvent extends ApplicationEvent {

    public TaskAssignedEvent(Object source) {
        super(source);
    }
}
