package com.etaskify.app.service.impl;

import com.etaskify.app.dto.TaskCreateRequest;
import com.etaskify.app.event.TaskAssignedEvent;
import com.etaskify.app.model.Task;
import com.etaskify.app.repository.TaskRepository;
import com.etaskify.app.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ApplicationEventPublisher publisher;

    @Override
    @Transactional(
            rollbackFor = Exception.class,
            propagation = Propagation.REQUIRED
    )
    public Task createTask(TaskCreateRequest taskCreateRequest) {
        Task task = new Task();

        publisher.publishEvent(new TaskAssignedEvent(task));
        return null;
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
