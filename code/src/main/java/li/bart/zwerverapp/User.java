package li.bart.zwerverapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class User {
	@Id
	@GeneratedValue
	private Long id;
	
	private String userName;
	private String password;
	public static enum userType {Supplier, Demander};
	public userType userpermission;
	
	public User() {}
	
	public User(String userName, String password, userType userpermission) {
		super();
		this.userName = userName;
		this.password = password;
		this.userpermission = userpermission;
	}

	public userType getUserpermission() {
		return userpermission;
	}

	public void setUserpermission(userType userpermission) {
		this.userpermission = userpermission;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}	
	

