package com.quickrole.To_do.dto;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import com.quickrole.To_do.entity.Priority;

import java.security.PrivateKey;
import java.time.LocalDate ;

@Data
public class TaskResponse {
    private Long id;
    private String title;
    private String description;
    private Priority priority;
    private boolean completed;
    private LocalDate dueDate;
}
