package li.bart.zwerverapp;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Demander extends User {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String photoURL;
	private String description;
	private int numberOfRequests;
	private String locationGPS;
	
	@OneToMany
	private List<Request> requests;
	
	public Demander() {
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhotoURL() {
		return photoURL;
	}

	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberOfRequests() {
		return numberOfRequests;
	}

	public void setNumberOfRequests(int numberOfRequests) {
		this.numberOfRequests = numberOfRequests;
	}

	public String getLocationGPS() {
		return locationGPS;
	}

	public void setLocationGPS(String locationGPS) {
		this.locationGPS = locationGPS;
	}

}
