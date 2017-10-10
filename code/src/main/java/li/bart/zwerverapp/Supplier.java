package li.bart.zwerverapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Supplier extends User{
	@Id
	@GeneratedValue
	private Long id;
	private int nRequests;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getnRequests() {
		return nRequests;
	}
	public void setnRequests(int nRequests) {
		this.nRequests = nRequests;
	}
}
