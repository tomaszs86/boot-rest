package pl.boot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.boot.rest.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}