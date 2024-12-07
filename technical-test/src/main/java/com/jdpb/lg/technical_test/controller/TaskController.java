package com.jdpb.lg.technical_test.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jdpb.lg.technical_test.controller.api.TaskApi;
import com.jdpb.lg.technical_test.model.TaskRequest;
import com.jdpb.lg.technical_test.repository.entity.TaskEntity;
import com.jdpb.lg.technical_test.service.TaskService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


@RestController
public class TaskController implements TaskApi {

    @Autowired
    private TaskService service;

    @Override
    public ResponseEntity<List<TaskEntity>> getTasks() {
        return ResponseEntity.ok(service.getTasks());
    }

    @Override
    public ResponseEntity<TaskEntity> getTaskById(String id) {
        return ResponseEntity.ok(service.getTaskById(id));
    }

    @Override
    public ResponseEntity<TaskEntity> createTask( @RequestBody @Valid TaskRequest request) {
        return ResponseEntity.ok(service.createTask(request));
    }

    @Override
    public ResponseEntity<TaskEntity> updateTask(TaskEntity request) {
        return ResponseEntity.ok(service.updateTask(request));
    }

    @Override
    public ResponseEntity<TaskEntity> deleteTask(String id) {
        return ResponseEntity.ok(service.deleteTask(id));
    }
    
}
