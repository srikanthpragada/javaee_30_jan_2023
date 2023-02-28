package inheritance.joined;

import javax.persistence.Entity;

@Entity
public class OfflineCourse extends Course {
	private String location;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	 
	
}
