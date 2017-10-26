package li.bart.zwerverapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Request {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(length=200000)
	private String photo;
	
	private String description;
	private String requestTitle;
	private int requestSupplier, requestDemander;
	private enum requestType {FOOD, CLOTHES, OTHER};
	private requestType inNeedOf;
	private Long createdBy;
	private Long helpedBy;
	
	public Long getHelpedBy() {
		return helpedBy;
	}
	public void setHelpedBy(Long helpedBy) {
		this.helpedBy = helpedBy;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
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
	public requestType getInNeedOf() {
		return inNeedOf;
	}
	public void setInNeedOf(requestType inNeedOf) {
		this.inNeedOf = inNeedOf;
	}
	public String getRequestTitle() {
		return requestTitle;
	}
	public void setRequestTitle(String requestTitle) {
		this.requestTitle = requestTitle;
	}
	public int getRequestSupplier() {
		return requestSupplier;
	}
	public void setRequestSupplier(int requestSupplier) {
		this.requestSupplier = requestSupplier;
	}
	public int getRequestDemander() {
		return requestDemander;
	}
	public void setRequestDemander(int requestDemander) {
		this.requestDemander = requestDemander;
	}
}
