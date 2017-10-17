package li.bart.zwerverapp.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import li.bart.zwerverapp.User;

@NoRepositoryBean
public interface UserRepository<T extends User> 
extends CrudRepository<User, Long> {

 
}