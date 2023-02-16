package hr;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Job;

public class FindJob {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_jan30");
		EntityManager em = emf.createEntityManager();

		var job = em.find(Job.class, "odba");
		System.out.println(job.getTitle());
		System.out.println(job.hashCode());

		var job2 = em.find(Job.class, "odba");
		System.out.println(job2.getTitle());
		System.out.println(job2.hashCode());

		em.close();
		// job is detached
		emf.close();
	}
}
