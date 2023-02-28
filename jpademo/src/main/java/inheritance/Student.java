package inheritance;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "inheritance.Student")
@DiscriminatorValue("2")  // Value to be stored in Discriminator Column 
public class Student extends Person {
	private String college;

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	@Override
	public String toString() {
		return "Student :  " +  id + " " + name + " " + college ;
	}
 
	
}
