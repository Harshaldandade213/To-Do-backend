package com.quickrole.To_do.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    private String desc;

    @Enumerated(EnumType.STRING)
    private Priority priority;   // ✅ your enum

    private boolean completed = false;

    private LocalDate dueDate;
}
