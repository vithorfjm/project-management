package br.com.vithorfjm.projectmanagement.repositories;

import br.com.vithorfjm.projectmanagement.entities.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByActiveTrue();

}
