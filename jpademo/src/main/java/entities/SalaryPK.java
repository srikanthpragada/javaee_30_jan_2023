package entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

// Primary key class 
@Embeddable
public class SalaryPK implements Serializable {
	@Column(name = "employee_id")
	private int employeeId;
	@Column(name = "salary_month", length = 10)
	private String salaryMonth;

	public SalaryPK() {
		super();
	}

	public SalaryPK(int employeeId, String salaryMonth) {
		super();
		this.employeeId = employeeId;
		this.salaryMonth = salaryMonth;
	}

	@Override
	public int hashCode() {
		return this.employeeId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalaryPK other = (SalaryPK) obj;
		return employeeId == other.employeeId && Objects.equals(salaryMonth, other.salaryMonth);
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getSalaryMonth() {
		return salaryMonth;
	}

	public void setSalaryMonth(String salaryMonth) {
		this.salaryMonth = salaryMonth;
	}

}
