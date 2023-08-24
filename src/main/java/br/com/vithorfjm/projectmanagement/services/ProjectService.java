package br.com.vithorfjm.projectmanagement.services;

import br.com.vithorfjm.projectmanagement.entities.project.Project;
import br.com.vithorfjm.projectmanagement.repositories.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project getProductById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project createProject(Project data) {
        Project project = new Project();
        project.setName(data.getName());
        project.setDescription(data.getDescription());
        project.setInitialDate(LocalDateTime.now());
        projectRepository.save(project);
        return project;
    }

    @Transactional
    public void updateProject(Project data) {
        Project project = projectRepository.findById(data.getId()).orElseThrow(() -> new RuntimeException());
        project.setName(data.getName());
        project.setDescription(data.getDescription());
    }

    @Transactional
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new RuntimeException());
        projectRepository.delete(project);
    }
}
