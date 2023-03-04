package onetoone;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListEmployees {

	public static void main(String[] args) throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_jan30_ddl");
		EntityManager em = emf.createEntityManager();

		List<Employee> employees = em.createQuery("from onetoone.Employee e join fetch e.project", Employee.class).getResultList();

		for (var emp : employees) {
			//System.out.printf("%s  %s\n", emp.getName(), emp.getProject().getTitle());
			System.out.println(emp.getName());
			var project = emp.getProject();
			System.out.println(project.getTitle());
			
			//System.out.println(project.getClass());
		}

		em.close();
		emf.close();
	}
}
