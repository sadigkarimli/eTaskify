package com.etaskify.app.event;

import com.etaskify.app.model.Email;
import com.etaskify.app.model.Task;
import com.etaskify.app.service.EmailService;
import com.etaskify.app.util.EmailBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskAssignedEventListener  {

    private final EmailService emailService;

    @EventListener
    @Async
    public void onTaskAssigned(TaskAssignedEvent event){

        Task task = (Task) event.getSource();
        Email email = EmailBuilder.buildTaskAssignedEmail(task);

        emailService.sendEmail(email);
    }
}
