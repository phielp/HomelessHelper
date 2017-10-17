package li.bart.zwerverapp.service;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import li.bart.zwerverapp.Demander;
import li.bart.zwerverapp.User;
 
@Transactional
public interface DemanderRepository extends UserRepository<User> {
	@Modifying
	@Transactional
	@Query("UPDATE User SET latitude = ?1, longitude = ?2 where id = ?3")
	public void setGPSLocation(Float latitude, Float longitude, Long id);

}
