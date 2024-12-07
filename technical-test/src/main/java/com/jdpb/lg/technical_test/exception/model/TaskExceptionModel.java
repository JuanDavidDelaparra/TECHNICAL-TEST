package com.jdpb.lg.technical_test.exception.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskExceptionModel {

    private String code;
    private String message;
    
}
