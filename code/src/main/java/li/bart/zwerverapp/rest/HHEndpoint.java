package li.bart.zwerverapp.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import li.bart.zwerverapp.Demander;
import li.bart.zwerverapp.Request;
import li.bart.zwerverapp.User;
import li.bart.zwerverapp.User.userType;
import li.bart.zwerverapp.service.DemanderRepository;
import li.bart.zwerverapp.service.HHRepository;
import li.bart.zwerverapp.service.HHService;

@RestController
public class HHEndpoint {
	@Autowired
	private HHService hhservice;
	@Autowired
	private HHRepository hhrepository;
	@Autowired
	private DemanderRepository demanderrepository;

	
	@GetMapping ("/zwerver")
	public String getZwerver() {
		return "jeow";
	}
	
	@GetMapping("/login")
	public Iterable<User> getLogin() {
		return hhservice.userList();
	}
	
	@PostMapping("/login")
	public ArrayList<Object> postLogin(@RequestBody User user) {
		Iterable<User> users = hhservice.userList();
		ArrayList<Object> check = hhservice.knownUser(users, user);
		return check;
	}
	
	@PostMapping("/createRequest")
	public void createRequest(@RequestBody Request request) {
		hhservice.postRequest(request);
	}
	
	@GetMapping("/demander")
	public Iterable<Request> getRequests() {
		return hhservice.requestList();
	}
	
	@DeleteMapping("/demander/{foo}")
	public void yoyo(@PathVariable long foo) {
		hhservice.deleteRequest(foo);
	}

	@GetMapping("/demander/{foo}")
	public Request heyo(@PathVariable long foo) {
		Request request = hhservice.showSingleRequest(foo);
		return request;
	}
	
	@PostMapping("/register")
	public boolean postRegister(@RequestBody User user) {
		Iterable<User> users = hhservice.userList();
		ArrayList<Object> check = hhservice.knownUser(users, user);
		Boolean a = (Boolean)check.get(0);
		if (a == false) {
			hhservice.registerUser(user);
			return true;
		}
		return false;
	}
	
	@PostMapping("/setlocation")
	public void setLocation(@RequestBody Demander demander) {
		Float latitude = demander.getLatitude();
		Float longitude = demander.getLongitude();
		Long id = demander.getId();
		demanderrepository.setGPSLocation(latitude, longitude, id);
	}
	
	@PostMapping("/getlocation")
	public Float[] getLocation(@RequestBody User user) {
		System.out.println(user.getId());
		
		User demander = hhservice.getDemander(user.getId());
		System.out.println(demander);

		Float[] location = new Float[2];
		location[0] = demander.getLatitude();
		location[1] = demander.getLongitude();
		return location;
	}
}

	