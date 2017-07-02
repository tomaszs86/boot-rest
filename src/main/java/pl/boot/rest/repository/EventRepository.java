package pl.boot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import pl.boot.rest.domain.Event;

@RepositoryRestResource(collectionResourceRel = "event", path = "event")
public interface EventRepository extends JpaRepository<Event, Integer> {

}
