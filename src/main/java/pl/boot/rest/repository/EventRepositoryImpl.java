package pl.boot.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaContext;

import pl.boot.rest.domain.Event;

public class EventRepositoryImpl implements EventRepositoryCustom {

	@Autowired
	private final EntityManager em;
	
	@Autowired
	public EventRepositoryImpl(JpaContext context) {
		this.em = context.getEntityManagerByManagedType(Event.class);
	}
	
	@Override
	public List<Event> getAll() { 
		CriteriaQuery<Event> criteria = em.getCriteriaBuilder().createQuery(Event.class);
	    criteria.select(criteria.from(Event.class));
	    return em.createQuery(criteria).getResultList();		
	}

}
