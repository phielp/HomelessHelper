package li.bart.zwerverapp.service;

import java.util.ArrayList;

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
	
	public void deleteRequest(long foo) {
		requestrepository.delete(foo);
	}
	
	
	public ArrayList<Object> knownUser(Iterable<User> knownUsers, User user) {
		ArrayList<Object> booleanLijst = new ArrayList<Object>();
		boolean check1 = false;
		boolean check2 = false;
		long check3 = 0;
		for (User knownUser : knownUsers) {
			if (knownUser.getUserName().equals(user.getUserName()) && (knownUser.getPassword().equals(user.getPassword()))) {
				check1 = true;
				if (knownUser.getUserpermission().equals(User.userType.Supplier))
					check2 = true;
				if (knownUser.getId().equals(user.getId()))
					check3 = user.getId();		
			}
		}
		booleanLijst.add(check1);
		booleanLijst.add(check2);
		booleanLijst.add(check3);
		return booleanLijst;
	}
	

	public Request postRequest(Request request) {
		requestrepository.save(request);
		return request;
	}

	public Iterable<Request> requestList() {
		return requestrepository.findAll();
	}

}

