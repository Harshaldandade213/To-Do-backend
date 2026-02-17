package com.quickrole.To_do.service;

import com.quickrole.To_do.dto.TaskRequest;
import com.quickrole.To_do.dto.TaskResponse;
import com.quickrole.To_do.repository.TaskRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.quickrole.To_do.entity.Task;

import java.util.List;
import java.util.Optional;

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

    public TaskResponse getById(Long id) {
        Task task= repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found")) ;
        TaskResponse response= new TaskResponse() ;
        response.setId((long) task.getId()) ;
        response.setTitle(task.getTitle()) ;
        response.setDesc(task.getDesc());
        response.setDueDate(task.getDueDate());
        response.setPriority(task.getPriority());

        return response ;

    }

    public void update(long id, @Valid TaskRequest request) {
        Task task= repository.findById(id).orElse(null) ;
        //TaskRequest taskRequest = new TaskRequest();
        task.setTitle(request.getTitle());
        task.setDesc(request.getDesc());
        task.setPriority(request.getPriority());
        task.setDueDate(request.getDueDate());

        repository.save(task);
   }

    public void delete(Long id) {
        Task task= repository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        repository.delete(task);
    }

    public void deleteAll() {
        //Task task = repository.findAll();
        repository.deleteAll();
    }

    public void markAsComplete(Long id, boolean flag) {
        Task task = repository.findById(id).orElseThrow(() -> new RuntimeException("No Task found with the id as : "));
        TaskResponse response=new TaskResponse() ;
        task.setCompleted(flag);
        repository.save(task) ;
    }

//    public
}
