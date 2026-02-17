package com.quickrole.To_do.dto;

import lombok.Data;
import com.quickrole.To_do.entity.Priority;

import java.time.LocalDate ;

@Data
public class TaskResponse {
    private Long id;
    private String title;
    private String desc;
    private Priority priority;
    private boolean completed;
    private LocalDate dueDate;
}
