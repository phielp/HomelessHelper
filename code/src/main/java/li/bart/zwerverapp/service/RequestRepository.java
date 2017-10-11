package li.bart.zwerverapp.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import li.bart.zwerverapp.User;

@Component
public interface RequestRepository extends CrudRepository<Request, Long> {

}
