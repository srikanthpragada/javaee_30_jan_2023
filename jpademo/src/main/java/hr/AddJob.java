package hr;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Job;

public class AddJob {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_jan30");
		EntityManager em = emf.createEntityManager();

		Job j = new Job();
		j.setId("sbp");
		j.setTitle("Spring Boot Developer");
		j.setMinsal(1000000);
		
		em.getTransaction().begin(); // start transaction 
		em.persist(j);
		em.getTransaction().commit(); // commit transaction
		
		em.close();
		emf.close();
	}
}
