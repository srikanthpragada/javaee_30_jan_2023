package crm;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Customer;
import entities.Job;

public class AddCustomer {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_jan30");
		EntityManager em = emf.createEntityManager();

		Customer c = new Customer();
		c.setEmail("larry@gmail.com");
		c.setFullname("Larry");
		c.setMobile("303939333");
		
		em.getTransaction().begin(); // start transaction 
		em.persist(c);
		em.getTransaction().commit(); // commit transaction
		
		em.close();
		emf.close();
	}
}
