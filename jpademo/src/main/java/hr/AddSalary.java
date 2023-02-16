package hr;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Salary;

public class AddSalary {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_jan30_ddl");
		EntityManager em = emf.createEntityManager();

		Salary s = new Salary(103,"JAN-2023", 70000);
		
		em.getTransaction().begin(); // start transaction
		em.persist(s);
		em.getTransaction().commit(); // commit transaction

		em.close();
		emf.close();
	}
}
