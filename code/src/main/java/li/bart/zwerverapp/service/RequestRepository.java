package li.bart.zwerverapp.service;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import li.bart.zwerverapp.Request;

@Component
public interface RequestRepository extends CrudRepository<Request, Long> {
	@Modifying
	@Transactional
	@Query("SELECT E from Request E where created_by = ?1")	
	public Iterable<Request> getMyRequests(Long userId);
	
	@Query("SELECT u.userName, r.description, r.requestTitle, r.id, r.photo from User u, Request r where r.createdBy = u.id" )
	public Iterable<Request> getAllRequestsPlusNames();
}
