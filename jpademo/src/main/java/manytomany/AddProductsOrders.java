package manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AddProductsOrders {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_jan30_ddl");
		EntityManager em = emf.createEntityManager();
		
		Product p1 = new Product();
		p1.setName("Product1");
		
		Product p2 = new Product();
		p2.setName("Product2");
		
		
		Order o1 = new Order();
		o1.setCustomer("Customer1");
		
		Order o2 = new Order();
		o2.setCustomer("Customer2");
		
		o1.getProducts().add(p1);
		o1.getProducts().add(p2);
		
		o2.getProducts().add(p2);
		
		p1.getOrders().add(o1);
		p2.getOrders().add(o1);
		p2.getOrders().add(o2);
		
		em.getTransaction().begin(); 
		em.persist(p1);
		em.persist(p2);
		em.persist(o1);
		em.persist(o2);
		
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
