package hr;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Job;

public class UpdateJob {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_jan30");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin(); // start transaction 
		
		var job = em.find(Job.class, "sbp");
		// job is in Managed state 
		job.setTitle("Spring Boot 2.0 Developer");
	
		em.getTransaction().commit(); // commit transaction
		
		em.close();
		// job is detached 
		emf.close();
	}
}
