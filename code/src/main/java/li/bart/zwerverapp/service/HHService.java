package li.bart.zwerverapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import li.bart.zwerverapp.Request;
import li.bart.zwerverapp.User;

@Service
@Transactional
public class HHService {
	
	@Autowired	
	HHRepository zwerverrepository;
	@Autowired
	RequestRepository requestrepository;
	
	
	public User registerUser(User user) {
		zwerverrepository.save(user);
		return user;
	}
	
	public Iterable<User> userList() {
		return zwerverrepository.findAll();
	}
	
	public boolean knownUser(Iterable<User> knownUsers, User user) {
		boolean check = false; 
		for (User knownUser : knownUsers) {
			if (knownUser.getUserName().equals(user.getUserName()) && (knownUser.getPassword().equals(user.getPassword())))
				check = true;
		}
		return check;
	}
	
	public Request postRequest(Request request) {
		requestrepository.save(request);
		return request;
	}
}

