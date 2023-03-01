package inheritance.joined;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "inheritance.joined.OnlineCourse")
@Table(name = "inh_onlinecourses")
public class OnlineCourse extends Course {
	@Column( length = 50)
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	 

}
