package li.bart.zwerverapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String userName, password;
	public enum userType {Supplier, Demander};
	public userType userpermission;
	
	
	
	
	
	

	public User(String userName, String password, userType userpermission) {
		super();
		this.userName = userName;
		this.password = password;
		this.userpermission = userpermission;
	}


	private enum userType {Supplier, Demander};
	private userType userPermission;

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
	

