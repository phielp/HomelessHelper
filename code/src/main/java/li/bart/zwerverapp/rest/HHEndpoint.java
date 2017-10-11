package li.bart.zwerverapp.rest;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import li.bart.zwerverapp.Request;
import li.bart.zwerverapp.User;
import li.bart.zwerverapp.User.userType;
import li.bart.zwerverapp.service.HHService;

@RestController
public class HHEndpoint {
	@Autowired
	HHService hhservice;
	
	@GetMapping ("/zwerver")
	public String getZwerver() {
		return "jeow";
	}
	
	@GetMapping("/login")
	public Iterable<User> getLogin() {
		return hhservice.userList();
	}
	
	@PostMapping("/login")
	public ArrayList<Boolean> postLogin(@RequestBody User user) {
		Iterable<User> users = hhservice.userList();
		ArrayList<Boolean> check = hhservice.knownUser(users, user);
		return check;
	}
	
	@PostMapping("/createRequest")
	public void createRequest(@RequestBody Request request) {
		hhservice.postRequest(request);
	}
	
	
	@PostMapping("/register")
	public boolean postRegister(@RequestBody User user) {
		Iterable<User> users = hhservice.userList();
		ArrayList<Boolean> check = hhservice.knownUser(users, user);
		if (check.get(0) == false) {
			hhservice.registerUser(user);
			return true;
		}
		return false;
	}
}

	