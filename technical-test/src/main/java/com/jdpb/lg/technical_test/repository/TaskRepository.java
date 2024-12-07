package com.jdpb.lg.technical_test.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jdpb.lg.technical_test.repository.entity.TaskEntity;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Long> {

    List<TaskEntity> findAll();
    Optional<TaskEntity> findById(Long id);
    
} 
