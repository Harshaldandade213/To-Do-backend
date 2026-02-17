package com.quickrole.To_do.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import com.quickrole.To_do.entity.Priority;

import java.security.PrivateKey;
import java.time.LocalDate ;
@Data
//@NotBlank

public class TaskRequest {
    @NotBlank(message = "Title is required")
    private String title ;

    private String desc ;

    private Priority priority ;

    private LocalDate dueDate ;


}
