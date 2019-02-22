package dev.a2.onlinestore.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.a2.onlinestore.model.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
	
    User findByEmail(String email);
}
