package li.bart.zwerverapp;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void testUserUsername() {
		User user = new User();
		String userNameTest = "hallo";
		user.setUserName(userNameTest);
		assertEquals(user.getUserName(), userNameTest);
	}
}
