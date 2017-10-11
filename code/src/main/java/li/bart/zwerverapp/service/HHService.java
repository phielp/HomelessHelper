package li.bart.zwerverapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import li.bart.zwerverapp.User;

@Service
@Transactional
public class HHService {
	
	@Autowired	
	HHRepository zwerverrepository;
	
	
	public User registerUser(User user) {
		zwerverrepository.save(user);
		return user;
	}
	
	public Iterable<User> userList() {
		return zwerverrepository.findAll();
	}
	
	public ArrayList<Boolean> knownUser(Iterable<User> knownUsers, User user) {
		ArrayList<Boolean> booleanLijst = new ArrayList<Boolean>();
		boolean check1 = false;
		boolean check2 = false;
		for (User knownUser : knownUsers) {
			if (knownUser.getUserName().equals(user.getUserName()) && (knownUser.getPassword().equals(user.getPassword()))) {
				check1 = true;
				if (knownUser.getUserpermission().equals(User.userType.Supplier))
					check2 = true;		
			}
		}
		booleanLijst.add(check1);
		booleanLijst.add(check2);
		return booleanLijst;
	}
	

}

