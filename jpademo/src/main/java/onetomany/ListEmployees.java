package onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListEmployees {

	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_jan30");
		EntityManager em = emf.createEntityManager();

		List<Employee> employees = em.createQuery("from onetomany.Employee", Employee.class).getResultList();

		for (Employee e : employees) {
			System.out.printf("%s - %s\n",  e.getName(), e.getJob().getTitle());
			//System.out.println(e.getName());
			
		}

		em.close();
		emf.close();
	}
}
