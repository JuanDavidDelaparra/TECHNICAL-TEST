package com.jdpb.lg.technical_test.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdpb.lg.technical_test.exception.type.NotFoundTaskException;
import com.jdpb.lg.technical_test.model.TaskRequest;
import com.jdpb.lg.technical_test.repository.TaskRepository;
import com.jdpb.lg.technical_test.repository.entity.TaskEntity;
import com.jdpb.lg.technical_test.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    public List<TaskEntity> getTasks() {
        return repository.findAll();
    }

    @Override
    public TaskEntity getTaskById(String id) {
        Long idParsed = Long.parseLong(id);
        return repository.findById(idParsed).orElseThrow(() -> new NotFoundTaskException());
    }

    @Override
    public TaskEntity createTask(TaskRequest task) {
        return repository.save(new TaskEntity(null, task.getTitle(), task.getDescription(), false));
    }

    @Override
    public TaskEntity updateTask(TaskEntity task) {
        TaskEntity entity = repository.findById(task.getId()).orElseThrow(() -> new NotFoundTaskException());
        entity.setTitle(Optional.of(task.getTitle()).orElse(entity.getTitle()));
        entity.setDescription(Optional.of(task.getDescription()).orElse(entity.getDescription()));
        entity.setStatus(Optional.of(task.isStatus()).orElse(entity.isStatus()));
        return repository.save(entity);
    }

    @Override
    public TaskEntity deleteTask(String id) {
        Long idParsed = Long.parseLong(id);
        TaskEntity entity = repository.findById(idParsed).orElseThrow(() -> new NotFoundTaskException());
        repository.delete(entity);
        return entity;
    }
    
}
