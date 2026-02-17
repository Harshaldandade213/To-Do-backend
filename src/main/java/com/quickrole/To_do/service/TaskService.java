package com.quickrole.To_do.service;

import com.quickrole.To_do.dto.TaskRequest;
import com.quickrole.To_do.repository.TaskRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.quickrole.To_do.entity.Task;

import java.util.List;

@Slf4j
@Service
//@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository repository ;
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }


    public void create(@Valid TaskRequest request) {
        Task task= new Task();
        task.setTitle(request.getTitle());
        task.setDesc(request.getDesc());
        task.setDueDate(request.getDueDate());
        task.setPriority(request.getPriority());


        repository.save(task);
      //  return null;
    }

    public List<Task> getAll() {
        return repository.findAll();
    }

//    public void getById(Long id) {
//    }
//
//    public
}
