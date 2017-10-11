package li.bart.zwerverapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Request {
	@Id
	@GeneratedValue
	private Long id;
	private String description, photo;
	private boolean requestSupplier, requestDemander;
	private enum requestType {FOOD, CLOTHES, OTHER};
	private requestType inNeedOf;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public boolean isRequestSupplier() {
		return requestSupplier;
	}
	public void setRequestSupplier(boolean requestSupplier) {
		this.requestSupplier = requestSupplier;
	}
	public boolean isRequestDemander() {
		return requestDemander;
	}
	public void setRequestDemander(boolean requestDemander) {
		this.requestDemander = requestDemander;
	}
	public requestType getInNeedOf() {
		return inNeedOf;
	}
	public void setInNeedOf(requestType inNeedOf) {
		this.inNeedOf = inNeedOf;
	}
}