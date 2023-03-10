package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@SpringBootApplication
public class Test implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Autowired
	private EmployeeService empService;

	public static void main(String[] args) {
		SpringApplication.run(Test.class, args);
	}

	public void printEmployeeCount() {
		var count = jdbcTemplate.queryForObject("select count(*) from employees", Integer.class);
		System.out.println(count);
	}

	public void printEmployeeNames() {
		var names = jdbcTemplate.queryForList("select fullname from employees", String.class);
		for(var n : names)
			System.out.println(n);
	}
	
	public void printEmployees() {
		var employees = jdbcTemplate.query("select * from employees", 
				          // Implement RowMapper using Lambda 
				          (rs, num) -> new Employee(rs.getString("fullname"), rs.getInt("salary")));
				 
		for(var e : employees)
			System.out.printf("%-20s  %8d\n", e.getName(), e.getSalary());
	}
	
	public void updateSalary(int empid, int newSalary) {
		int count = jdbcTemplate.update
				("update employees set salary = ? where id  = ?", newSalary, empid);
		System.out.println("Update count  : " + count);
	}
	
	
	public void updateSalary2(int empid, int newSalary) {
		var params = new MapSqlParameterSource()
				            .addValue("salary",newSalary)
				            .addValue("id",  empid);
		
		int count = namedJdbcTemplate.update
				("update employees set salary = :salary where id  = :id", params);
		System.out.println("Update count  : " + count);
	}
	
	
	@Override
	public void run(String... args) throws Exception {
		 empService.updateSalaries(1, 2, 100000);
	}

}