package pl.boot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.boot.rest.domain.Session;

public interface SessionRepository extends JpaRepository<Session, Integer> {

}