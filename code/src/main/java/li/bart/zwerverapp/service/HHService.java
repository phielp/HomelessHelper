package li.bart.zwerverapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import li.bart.zwerverapp.User;

@Service
@Transactional
public class HHService {
	
	@Autowired	
	HHRepository zwerverrepository;
	
	
	public User test(User user) {
		zwerverrepository.save(user);
		return user;
	}
	
	public Iterable<User> userList() {
		return zwerverrepository.findAll();
	}
}

