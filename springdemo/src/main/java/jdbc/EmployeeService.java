package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Component 
public class EmployeeService {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateSalaries(int first, int second, int salary) {
		TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
		System.out.println(status.isNewTransaction());
		
		int count = jdbcTemplate.update
				("update employees set salary = salary + ? where id  = ?", salary, first);
		
		if(count == 0)
			throw new IllegalArgumentException("Employee " + first  + " not found");
		
		count = jdbcTemplate.update
				("update employees set salary = salary - ? where id  = ?", salary, second);
		
		if(count == 0)
			throw new IllegalArgumentException("Employee " + second  + " not found");
	}
	
}
