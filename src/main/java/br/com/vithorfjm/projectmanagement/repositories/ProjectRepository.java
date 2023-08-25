package br.com.vithorfjm.projectmanagement.repositories;

import br.com.vithorfjm.projectmanagement.entities.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p WHERE p.id = :id AND p.active = true")
    Optional<Project> findActiveProjectById(Long id);

    List<Project> findByActiveTrue();



}
