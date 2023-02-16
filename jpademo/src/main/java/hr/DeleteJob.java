package hr;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Job;

public class DeleteJob {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_jan30");
		EntityManager em = emf.createEntityManager();

		var job = em.find(Job.class, "sbp");
		em.getTransaction().begin(); // start transaction
		em.remove(job);
		//job is in Removed state 
		em.getTransaction().commit(); // commit transaction

		em.close();
		emf.close();
	}
}
