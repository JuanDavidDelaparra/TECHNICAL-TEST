package com.jdpb.lg.technical_test.service;

import java.util.List;

import com.jdpb.lg.technical_test.model.TaskRequest;
import com.jdpb.lg.technical_test.repository.entity.TaskEntity;

public interface TaskService {

    List<TaskEntity> getTasks();
    TaskEntity getTaskById(String id);
    TaskEntity createTask(TaskRequest task);
    TaskEntity updateTask(TaskEntity task);
    TaskEntity deleteTask(String id);
    
}
