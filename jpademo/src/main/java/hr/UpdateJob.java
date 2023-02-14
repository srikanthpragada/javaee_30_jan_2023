package hr;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Job;

public class UpdateJob {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_jan30");
		EntityManager em = emf.createEntityManager();

		var job = em.find(Job.class, "sbp");
		System.out.println(job.getTitle());
		
//		em.getTransaction().begin(); // start transaction 
//		em.persist(j);
//		em.getTransaction().commit(); // commit transaction
		
		em.close();
		emf.close();
	}
}
