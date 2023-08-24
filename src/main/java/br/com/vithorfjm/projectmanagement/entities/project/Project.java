package br.com.vithorfjm.projectmanagement.entities.project;

import br.com.vithorfjm.projectmanagement.entities.task.Task;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private LocalDateTime initialDate;

    public Project() {
    }

    public Project(String name, String description, LocalDateTime initialDate) {
        this.name = name;
        this.description = description;
        this.initialDate = initialDate;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDateTime initialDate) {
        this.initialDate = initialDate;
    }
}
