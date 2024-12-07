package com.jdpb.lg.technical_test.exception.handler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jdpb.lg.technical_test.exception.model.TaskExceptionModel;
import com.jdpb.lg.technical_test.exception.type.NotFoundTaskException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class TaskExceptionHandler {

    @ExceptionHandler(value = NotFoundTaskException.class)
    public final ResponseEntity<?> handleNotFoundExceptions(final NotFoundTaskException exception){
        TaskExceptionModel response = new TaskExceptionModel("404", "Not found tasks");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(value = Exception.class)
    public final ResponseEntity<?> handleGeneralException(final Exception exception){
        TaskExceptionModel response = new TaskExceptionModel("500", exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    
}
