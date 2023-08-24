package br.com.vithorfjm.projectmanagement.repositories;

import br.com.vithorfjm.projectmanagement.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
