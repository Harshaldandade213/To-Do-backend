package com.quickrole.To_do.controller;

import com.quickrole.To_do.dto.TaskRequest;
import com.quickrole.To_do.dto.TaskResponse;
import com.quickrole.To_do.entity.Task;
import com.quickrole.To_do.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping("/")
    public void create(@Valid @RequestBody TaskRequest request) {
        service.create(request);
    }

    @GetMapping("/getall")
    public List<Task> getAll() {
        return service.getAll();

    }
    @GetMapping("/{id}")
    public TaskResponse getById(@PathVariable Long id) {
        return service.getById(id);   // ← must return TaskResponse object directly
    }
    @PutMapping("/{id}")
    public void update(@PathVariable long id, @Valid @RequestBody TaskRequest request){
        service.update(id, request);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         service.delete(id);
    }
    @DeleteMapping("/")
    public void deleteAll(){
        service.deleteAll();
    }
//
//    //Mark as complete using Patch
    @PatchMapping("/{id}/complete")
    public void markAsComplete(@PathVariable Long id){
        service.markAsComplete(id, false);
    }







}