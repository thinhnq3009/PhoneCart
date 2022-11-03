package eco.phonecart.app.helper;

import java.io.Serializable;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import eco.phonecart.app.model.Users;
import eco.phonecart.app.utils.JpaUtils;

public class DatabaseHelper {

	public static boolean insert(Serializable entity) throws Exception{

		EntityManager entityManager = JpaUtils.getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		boolean result = false;

		try {
			entityTransaction.begin();

			entityManager.persist(entity);

			entityTransaction.commit();

			result = true;

		} catch (Exception e) {
			e.printStackTrace();

			System.out.println(e.getMessage());

			entityTransaction.rollback();

		} finally {

			entityManager.close();

		}

		return result;

	}

	public static boolean update(Serializable entity) throws Exception{

		EntityManager entityManager = JpaUtils.getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		boolean result = false;

		try {
			entityTransaction.begin();

			entityManager.merge(entity);

			entityTransaction.commit();

			result = true;

		} catch (Exception e) {
			e.printStackTrace();

			System.out.println(e.getMessage());

			entityTransaction.rollback();

		} finally {

			entityManager.close();

		}

		return result;

	}
	

	public static boolean delete(Serializable entity) throws Exception{

		EntityManager entityManager = JpaUtils.getEntityManager();

		EntityTransaction entityTransaction = entityManager.getTransaction();

		boolean result = false;

		try {
			entityTransaction.begin();

			entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));

			entityTransaction.commit();

			result = true;

		} catch (Exception e) {
			e.printStackTrace();

			System.out.println(e.getMessage());

			entityTransaction.rollback();

		} finally {

			entityManager.close();

		}

		return result;

	}

////	public static List<Serializable> query(String sql, Object...objects) {
////		
////		EntityManager entityManager = JpaUtils.getEntityManager();
////		
////		String sql = "SELECT u FROM Users u WHERE remember = :remember";
////		
////		TypedQuery<Users> query = entityManager.createQuery(sql, Users.class);
////		
////		query.setParameter(1, remember);
////		
////		return query.getSingleResult();
////	}
//	
}
