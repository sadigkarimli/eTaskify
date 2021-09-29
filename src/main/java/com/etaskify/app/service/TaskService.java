package com.etaskify.app.service;

import com.etaskify.app.dto.TaskCreateRequest;
import com.etaskify.app.model.Task;

public interface TaskService {

    Task createTask(TaskCreateRequest taskCreateRequest);

    void deleteTask(Long taskId);
}
