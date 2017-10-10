package li.bart.zwerverapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
	@GetMapping("/zwerver2")
	public User getZwerverTwee() {
		User user = new User ("arie","geheim", userType.Demander);
		hhservice.test(user);
		return user;
	}
	
	@PostMapping("/register")
	public void postEntity(@RequestBody User user) {
		System.out.println(user.getUserName());
		System.out.println(user.getPassword());
		hhservice.test(user);
	}

}

	