package br.com.vithorfjm.projectmanagement.repositories;

import br.com.vithorfjm.projectmanagement.entities.project.Project;
import br.com.vithorfjm.projectmanagement.entities.task.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT t FROM Task t WHERE t.id = :id AND t.active = true")
    Optional<Task> findActiveTaskById(Long id);

    @Query("SELECT t FROM Task t WHERE t.project.id = :projectId AND t.active = true")
    List<Task> findActiveTaskByProjectId(Long projectId);
}
