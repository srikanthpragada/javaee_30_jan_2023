package query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class NamedQueryDemo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_jan30");
		EntityManager em = emf.createEntityManager();
		
		Query query =   em.createNamedQuery("costlyemployees", Employee.class);
		List<Employee>  costlyEmployees = query.getResultList();
		
		for(var e : costlyEmployees) {
			 System.out.println(e);
		}
			
		 
		em.close();
		emf.close();

	}

}
