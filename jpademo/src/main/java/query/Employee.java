package query;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
  
@Table(name = "employees") 
@Entity(name = "query.Employee")
//@NamedQuery(name = "costlyemployees", query = "from query.Employee where salary > 500000")
public class Employee {
	@Id
	private int id;
	private String fullname;
	private int salary;
	
	@ManyToOne (fetch = FetchType.LAZY)
 	@JoinColumn(name="job")   // Foreign key 
	private Job job;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullname=" + fullname + ", salary=" + salary + ", job=" + job.getTitle() + "]";
	}
	
	
	
}
