package li.bart.zwerverapp.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import li.bart.zwerverapp.User;

@Component
public interface HHRepository extends CrudRepository<User, Long> {

}
