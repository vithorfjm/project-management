package br.com.vithorfjm.projectmanagement.services;

import br.com.vithorfjm.projectmanagement.entities.project.Project;
import br.com.vithorfjm.projectmanagement.entities.project.ProjectDTO;
import br.com.vithorfjm.projectmanagement.entities.task.Task;
import br.com.vithorfjm.projectmanagement.exceptions.EntityNotFoundException;
import br.com.vithorfjm.projectmanagement.repositories.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project getProjectById(Long id) {
        Project project = projectRepository.findActiveProjectById(id).orElseThrow(() -> new EntityNotFoundException("Project not found - " + id));
        List<Task> activeTasks = project.getTasks().stream()
                .filter(task -> task.isActive())
                .collect(Collectors.toList());
        project.setTasks(activeTasks);
        return project;
    }

    public List<Project> getAllProjects() {
        List<Project> projectsActiveTrue = projectRepository.findByActiveTrue();

        projectsActiveTrue.forEach(project -> {
            List<Task> activeTasks = project.getTasks().stream()
                    .filter(task -> task.isActive())
                    .collect(Collectors.toList());
            project.setTasks(activeTasks);
        });

        return projectsActiveTrue;
    }

    public Project createProject(ProjectDTO data) {
        Project newProject = new Project();
        newProject.setName(data.name());
        newProject.setDescription(data.description());
        newProject.setInitialDate(LocalDate.now());
        newProject.setStatus(data.status());
        newProject.setActive(true);
        projectRepository.save(newProject);
        return newProject;
    }

    @Transactional
    public void updateProject(ProjectDTO data) {
        Project project = projectRepository.findActiveProjectById(data.id()).orElseThrow(() -> new EntityNotFoundException("Project not found - " + data.id()));
        project.setName(data.name());
        project.setDescription(data.description());
        project.setStatus(data.status());
    }

    @Transactional
    public void deleteProject(Long id) {
        Project project = projectRepository.findActiveProjectById(id).orElseThrow(() -> new EntityNotFoundException("Project not found - " + id));
        List<Task> projectTasks = project.getTasks();
        projectTasks.forEach(task -> task.setActive(false)); // set all tasks in project to inactive.
        project.setActive(false);
    }
}
