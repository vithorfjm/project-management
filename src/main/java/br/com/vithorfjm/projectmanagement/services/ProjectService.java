package br.com.vithorfjm.projectmanagement.services;

import br.com.vithorfjm.projectmanagement.entities.project.Project;
import br.com.vithorfjm.projectmanagement.entities.project.ProjectDTO;
import br.com.vithorfjm.projectmanagement.repositories.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project getProjectById(Long id) {
        return projectRepository.findActiveProjectById(id).orElseThrow(() -> new RuntimeException());
    }

    public List<Project> getAllProjects() {
        return projectRepository.findByActiveTrue();
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
        Project project = projectRepository.findById(data.id()).orElseThrow(() -> new RuntimeException());
        project.setName(data.name());
        project.setDescription(data.description());
        project.setStatus(data.status());
    }

    @Transactional
    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new RuntimeException());
        project.setActive(false);
    }
}
