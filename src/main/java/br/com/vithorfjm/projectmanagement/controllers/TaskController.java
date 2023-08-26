package br.com.vithorfjm.projectmanagement.controllers;

import br.com.vithorfjm.projectmanagement.entities.task.Task;
import br.com.vithorfjm.projectmanagement.entities.task.TaskDTO;
import br.com.vithorfjm.projectmanagement.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/project/{projectId}/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@PathVariable Long projectId, @RequestBody TaskDTO data) {
        Task newTask = this.taskService.createTask(projectId, data);
        return ResponseEntity.ok(newTask);
    }

    @PutMapping
    public ResponseEntity<Task> updateTask(@PathVariable Long projectId, @RequestBody TaskDTO data) {
        this.taskService.updateTask(projectId, data);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(
            @PathVariable Long projectId,
            @PathVariable Long id) {
        this.taskService.deleteTask(projectId, id);
        return ResponseEntity.noContent().build();
    }

}
