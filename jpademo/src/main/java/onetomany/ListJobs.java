package onetomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListJobs {

	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_jan30");
		EntityManager em = emf.createEntityManager();

		List<Job> jobs = em.createQuery("from onetomany.Job", Job.class).getResultList();
 
		for (Job job : jobs) {
			System.out.println(job.getTitle());
			for(var emp : job.getEmployees())
				System.out.println("***" + emp.getName());
		}
		
	    em.close();
	    emf.close();
	}
}
 