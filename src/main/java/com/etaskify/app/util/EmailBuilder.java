package com.etaskify.app.util;

import com.etaskify.app.model.Email;
import com.etaskify.app.model.Task;
import com.etaskify.app.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class EmailBuilder {

    public static final String TASK_ASSIGNED_MAIL_SUBJECT = "Task Assignment #%s";
    public static final String TASK_ASSIGNED_MAIL_BODY = "New task %s assigned to you";

    public static Email buildTaskAssignedEmail(Task task) {
        List<String> sendTo = task.getUsers().stream()
                .map(User::getEmail).collect(Collectors.toList());

        return Email.builder()
                .sendTo(sendTo)
                .subject(String.format(TASK_ASSIGNED_MAIL_SUBJECT, task.getId()))
                .body(String.format(TASK_ASSIGNED_MAIL_BODY, task.getTitle()))
                .build();
    }
}
