package entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "salaries")
public class Salary {

	@EmbeddedId
	private SalaryPK key; // Composite primary key
	private int salary;

	public Salary(int employeeId, String salaryMonth, int salary) {
		this.key = new SalaryPK(employeeId, salaryMonth);
		this.salary = salary;
	}

	public Salary() {
		super();
	}

	public SalaryPK getKey() {
		return key;
	}

	public void setKey(SalaryPK key) {
		this.key = key;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
