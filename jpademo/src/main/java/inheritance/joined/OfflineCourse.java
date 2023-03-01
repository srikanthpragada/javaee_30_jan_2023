package inheritance.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "inheritance.joined.OfflineCourse")
@Table(name = "inh_offlinecourses")
public class OfflineCourse extends Course {
	@Column( length = 50)
	private String location;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	 
	
}
