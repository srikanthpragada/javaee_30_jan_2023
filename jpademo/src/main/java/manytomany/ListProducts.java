package manytomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListProducts {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql_jan30_ddl");
		EntityManager em = emf.createEntityManager();

		var query = em.createQuery("from manytomany.Product", Product.class);
		var products = query.getResultList();

		for (var p : products) {
			System.out.println(p.getName());
			for (var o : p.getOrders()) {
				System.out.println(o.getCustomer());
			}
		}

		em.close();
		emf.close();
	}
}
