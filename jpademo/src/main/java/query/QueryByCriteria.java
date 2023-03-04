package query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class QueryByCriteria {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_jan30");
		EntityManager em = emf.createEntityManager();
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Job> cr = cb.createQuery(Job.class);
		Root<Job> root = cr.from(Job.class);
		cr.select(root).where(cb.between(root.get("minsal"), 100000, 1000000));;
		
		Query query = em.createQuery(cr);
		List<Job> jobs = query.getResultList();
		
		for(var j : jobs) {
			 System.out.println(j.getTitle());
		}
		 
		em.close();
		emf.close();

	}

}
