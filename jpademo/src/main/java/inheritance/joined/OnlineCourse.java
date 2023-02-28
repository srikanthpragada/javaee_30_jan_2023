package inheritance.joined;

import javax.persistence.Entity;

@Entity
public class OnlineCourse extends Course {
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	 

}
