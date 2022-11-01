package eco.phonecart.app.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtils {
	public static EntityManager getEntityManager() {
		EntityManagerFactory fatory = Persistence.createEntityManagerFactory("PhoneCartShop");

		return fatory.createEntityManager();
	}
}
