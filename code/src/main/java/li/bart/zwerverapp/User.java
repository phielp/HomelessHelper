package li.bart.zwerverapp;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String userName, password;
	private enum userType {Supplier, Demander};
	private userType userPermission;
	@OneToMany
	private List<Demander> demanders;
	@OneToMany
	private List<Supplier> suppliers;
	
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

	public userType getUserPermission() {
		return userPermission;
	}

	public void setUserPermission(userType userPermission) {
		this.userPermission = userPermission;
	}	
}
