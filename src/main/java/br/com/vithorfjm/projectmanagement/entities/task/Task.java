package br.com.vithorfjm.projectmanagement.entities.task;

import br.com.vithorfjm.projectmanagement.entities.project.Project;
import br.com.vithorfjm.projectmanagement.entities.user.User;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity(name="task")
@Table
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDateTime initialDate;

    private LocalDateTime estimatedTerm;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Task() {
    }

    public Task(String title, String description, LocalDateTime initialDate, LocalDateTime estimatedTerm) {
        this.title = title;
        this.description = description;
        this.initialDate = initialDate;
        this.estimatedTerm = estimatedTerm;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public LocalDateTime getEstimatedTerm() {
        return estimatedTerm;
    }

    public void setEstimatedTerm(LocalDateTime estimatedTerm) {
        this.estimatedTerm = estimatedTerm;
    }
}
