package com.jdpb.lg.technical_test.controller.api;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jdpb.lg.technical_test.model.TaskRequest;
import com.jdpb.lg.technical_test.repository.entity.TaskEntity;

import io.swagger.v3.oas.annotations.Operation;

public interface TaskApi {

    @GetMapping("/api/tasks")
    @Operation(summary = "Service for list all task", tags = "Task")
    public ResponseEntity<List<TaskEntity>> getTasks();

    @GetMapping("/api/tasks/{id}")
    @Operation(summary = "Service to get task by ID", tags = "Task")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable String id);

    @PostMapping("/api/task")
    @Operation(summary = "Service to create a new task", tags = "Task")
    public ResponseEntity<TaskEntity> createTask( @RequestBody TaskRequest request);

    @PutMapping("/api/task")
    @Operation(summary = "Service to update a task", tags = "Task")
    public ResponseEntity<TaskEntity> updateTask(@RequestBody TaskEntity request);

    @DeleteMapping("/api/task/{id}")
    @Operation(summary = "Service to delete a task", tags = "Task")
    public ResponseEntity<TaskEntity> deleteTask(@PathVariable String id);
    
} 
