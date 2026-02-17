package com.quickrole.To_do.repository;
import com.quickrole.To_do.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
