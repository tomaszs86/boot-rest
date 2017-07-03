package pl.boot.rest.repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import pl.boot.rest.domain.Event;
import pl.boot.rest.projection.EventWithoutDependencies;

@RepositoryRestResource(collectionResourceRel = "event", path = "event")
public interface EventRepository extends JpaRepository<Event, Integer>, EventRepositoryCustom  {

	List<Event> findByLocationCity(String city);

	Long countById(Integer id);
	Long countByOnlineUrl(String onlineUrl);

	List<Event> findByName(String name);
	Event findFirst2ByName(String name);
	List<Event> findByNameAndPrice(String name, Double price);
	
	Long deleteByDate(Date date);
	List<Event> removeById(Integer id);

	List<Event> findByNameOrderByPriceDesc(String name);
	
	@Query("SELECT max(e.id) FROM #{#entityName} e")
	Integer getMaxId();	
	
	@Query("select e from #{#entityName} e where e.id = ?1")
	Event findById(Integer eventId);

	List<Event> findByImageUrl(String imageUrl, Sort sort);
	Page<Event> findByOnlineUrl(String onlineUrl, Pageable pageable);

	Stream<Event> readAllByNameNotNull();
	
	@Query("select e from #{#entityName} e")
	Stream<Event> findAllByCustomQueryAndStream();
	
	EventWithoutDependencies findByTime(String time);
	
	@Query("select e.id, e.name from #{#entityName} e where e.name like :name")
	List<Object[]> findByAsNameAndSort(@Param("name") String name, Sort sort);
	                            
	@Modifying
	@Transactional
	@Query("update #{#entityName} e set e.name=:name where e.id=:id")
	int updateEntityName(@Param("name") String name, @Param("id") Integer id);	
}