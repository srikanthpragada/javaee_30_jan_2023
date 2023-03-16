package springmvc.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "jobs")
@Entity
public class Job {
	@Id
	private String id;
	
	@Column 
	private String title;
	
	@Column(name = "minsal")
	private Integer minsal;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getMinsal() {
		return minsal;
	}

	public void setMinsal(int minsal) {
		this.minsal = minsal;
	}

}
