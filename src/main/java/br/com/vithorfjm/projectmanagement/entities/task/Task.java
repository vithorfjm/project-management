package br.com.vithorfjm.projectmanagement.entities.task;

import br.com.vithorfjm.projectmanagement.entities.project.Project;
import br.com.vithorfjm.projectmanagement.entities.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private LocalDate initialDate;

    private LocalDate estimatedTerm;

    private String status;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Task() {
    }

    public Task(String title, String description, LocalDate initialDate, LocalDate estimatedTerm) {
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

    public LocalDate getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public LocalDate getEstimatedTerm() {
        return estimatedTerm;
    }

    public void setEstimatedTerm(LocalDate estimatedTerm) {
        this.estimatedTerm = estimatedTerm;
    }
}
