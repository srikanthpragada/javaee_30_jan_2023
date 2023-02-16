package hr;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Programmer;

public class AddProgrammer {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_jan30_ddl");
		EntityManager em = emf.createEntityManager();

		Programmer p = new Programmer();
		p.setName("Larry");
		p.getSkills().add("Java");
		p.getSkills().add("Python");
		
		em.getTransaction().begin(); // start transaction
		em.persist(p);
		em.getTransaction().commit(); // commit transaction

		em.close();
		emf.close();
	}
}
