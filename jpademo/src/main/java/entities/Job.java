package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "jobs")
@Entity
public class Job {
	@Id
	private String id;
	
	@Column 
	private String title;
	
	@Column(name = "minsal")
	private int minsal;

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

	public int getMinsal() {
		return minsal;
	}

	public void setMinsal(int minsal) {
		this.minsal = minsal;
	}

}
