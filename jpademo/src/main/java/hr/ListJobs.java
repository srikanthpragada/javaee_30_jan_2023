package hr;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Job;

public class ListJobs {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_jan30");
		EntityManager em = emf.createEntityManager();

		var jobs = em.createQuery("from Job", Job.class).getResultList();

		for (Job job : jobs) {
			System.out.printf("%s  %s\n", job.getId(), job.getTitle());
		}

		em.close();
		emf.close();
	}
}
