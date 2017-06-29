package pl.boot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.boot.rest.domain.Event;

public interface EventRepository extends JpaRepository<Event, Integer> {

}
