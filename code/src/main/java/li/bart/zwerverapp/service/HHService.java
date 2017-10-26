package li.bart.zwerverapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import li.bart.zwerverapp.Demander;
import li.bart.zwerverapp.Request;
import li.bart.zwerverapp.User;

@Service
@Transactional
public class HHService {
	
	@Autowired	
	private HHRepository zwerverrepository;
	@Autowired
	private RequestRepository requestrepository;
	@Autowired
	private DemanderRepository demanderrepository;
	
	public User registerUser(User user) {
		zwerverrepository.save(user);
		return user;
	}
	
	public Iterable<User> userList() {
		return zwerverrepository.findAll();
	}
	
	public void deleteRequest(long requestId) {
		requestrepository.delete(requestId);
	}
	
	public Request showSingleRequest(long requestId) {
		Request request = requestrepository.findOne(requestId);
		return request;
	}
	
	public ArrayList<Object> knownUser(Iterable<User> knownUsers, User user) {
		ArrayList<Object> booleanLijst = new ArrayList<Object>();
		boolean check1 = false;
		boolean check2 = false;
		long check3 = 0L;
		for (User knownUser : knownUsers) {
			if (knownUser.getUserName().equals(user.getUserName()) && (knownUser.getPassword().equals(user.getPassword()))) {
				check1 = true;
				check3 = knownUser.getId();
				if (knownUser.getUserpermission().equals(User.userType.Supplier))
					check2 = true;	
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

	public User getDemander(Long userId) {
		return demanderrepository.findOne(userId);
	}
	
	public void setRequestAccept(Request request) {
		requestrepository.save(request);
	}
	
	
}

