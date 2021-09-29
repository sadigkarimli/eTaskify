package com.etaskify.app.event;

import com.etaskify.app.model.Email;
import com.etaskify.app.model.Task;
import com.etaskify.app.service.EmailService;
import com.etaskify.app.service.TaskService;
import com.etaskify.app.util.EmailBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
@RequiredArgsConstructor
public class TaskAssignedEventListener  {

    private final EmailService emailService;
    private final TaskService taskService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onTaskAssigned(TaskAssignedEvent event){

        log.info("Task assigned event is listening...");
        Task assignedTask = (Task) event.getSource();

        try {
            Email email = EmailBuilder.buildTaskAssignedEmail(assignedTask);
            emailService.sendEmail(email);
            log.info("Email can be sent to assigned users.");

        } catch (Exception ex) {
            log.error("Fail to send email to assigned users, removing assigned task id: {}.",
                    assignedTask.getId());
            taskService.deleteTask(assignedTask.getId());
        }
    }
}
