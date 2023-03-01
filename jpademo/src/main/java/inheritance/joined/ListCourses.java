package inheritance.joined;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListCourses {
	
	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_jan30_ddl");
		EntityManager em = emf.createEntityManager();

		var courses = em.createQuery("from inheritance.joined.OnlineCourse", Course.class).getResultList();

		for (var course : courses) {
			System.out.println(course.getClass());
			System.out.printf("%s\n", course.getName());
		}
		
	    em.close();
	    emf.close();
	}
}
