package br.com.vithorfjm.projectmanagement.services;

import br.com.vithorfjm.projectmanagement.entities.project.Project;
import br.com.vithorfjm.projectmanagement.entities.task.Task;
import br.com.vithorfjm.projectmanagement.entities.task.TaskDTO;
import br.com.vithorfjm.projectmanagement.exceptions.EntityNotFoundException;
import br.com.vithorfjm.projectmanagement.repositories.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ProjectService projectService;

    public Task createTask(Long projectId, TaskDTO data) {
        Project project = this.projectService.getProjectById(projectId);
//        User user = this.userService.getUserById(data.user_id);
        Task newTask = new Task();

        newTask.setTitle(data.title());
        newTask.setDescription(data.description());
        newTask.setInitialDate(LocalDate.now());
        newTask.setEstimatedTerm(LocalDate.parse(data.estimatedTerm()));
        newTask.setStatus(data.status());
        newTask.setActive(true);
        newTask.setProject(project);
//        newTask.setUser(user);

        this.taskRepository.save(newTask);

        return newTask;
    }

    @Transactional
    public void updateTask(Long projectId, TaskDTO data) {
        Task task = this.taskRepository.findActiveTaskById(data.id()).orElseThrow(() -> new EntityNotFoundException("Task not found - " + data.id()));
        if (!(task.getProject().getId().equals(projectId))) {
            throw new EntityNotFoundException("Task " + data.id() + " not found at project " + projectId);
        }

        task.setTitle(data.title());
        task.setDescription(data.description());
        task.setEstimatedTerm(LocalDate.parse(data.estimatedTerm()));
        task.setStatus(data.status());
    }

    @Transactional
    public void deleteTask(Long projectId, Long id) {
        Task task = this.taskRepository.findActiveTaskById(id).orElseThrow(() -> new EntityNotFoundException("Task not found - " + id));
        if (!(task.getProject().getId().equals(projectId))) {
            throw new EntityNotFoundException("Task " + id + " not found at project " + projectId);
        }
        task.setActive(false);
    }
}
