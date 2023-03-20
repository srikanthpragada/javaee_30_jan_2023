package springmvc.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

	@OneToMany(mappedBy = "job")
	@JsonIgnore
	private List<Employee> employees = new ArrayList<>();
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
