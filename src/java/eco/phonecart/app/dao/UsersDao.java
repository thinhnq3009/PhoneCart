package eco.phonecart.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import eco.phonecart.app.helper.DatabaseHelper;
import eco.phonecart.app.model.Users;
import eco.phonecart.app.utils.JpaUtils;

public class UsersDao {

	private final List<Users> gets(String username, boolean getAll) throws Exception {

		EntityManager entityManager = JpaUtils.getEntityManager();

		String sql = "SELECT u FROM Users u WHERE username = :username OR 1 = :getAll";

		TypedQuery<Users> typedQuery = entityManager.createQuery(sql, Users.class);

		typedQuery.setParameter("username", username);

		typedQuery.setParameter("getAll", getAll ? 1 : 0);

				
		List<Users> list = typedQuery.getResultList();

		return list;
	}

	public List<Users> getAll() throws Exception {
		return gets("", true);
	}

	public Users getByRememberCode(String rememberCode) throws Exception{
		
		EntityManager entityManager = JpaUtils.getEntityManager();
		
		String sql = "SELECT u FROM Users u WHERE remember = :remember";
		
		TypedQuery<Users> query = entityManager.createQuery(sql, Users.class);
		
		query.setParameter("remember", rememberCode);
		
		return query.getSingleResult();
		
	}
	
	

	public Users get(String username) throws Exception {

		List<Users> list = gets(username, false);
		
		return list.isEmpty() ? null : list.get(0);

	}

	public boolean update(Users user) throws Exception{
		
		return DatabaseHelper.update(user);
		
//		EntityManager entityManager = JpaUtils.getEntityManager();
//
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//
//		boolean result = false;
//
//		try {
//			entityTransaction.begin();
//
//			entityManager.merge(user);
//
//			entityTransaction.commit();
//
//			result = true;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//			System.out.println(e.getMessage());
//
//			entityTransaction.rollback();
//
//		} finally {
//
//			entityManager.close();
//
//		}
//
//		return result;
//		
		
	}
	
 	public boolean insert(Users user) throws Exception {

 		return DatabaseHelper.insert(user);
 		
//		EntityManager entityManager = JpaUtils.getEntityManager();
//
//		EntityTransaction entityTransaction = entityManager.getTransaction();
//
//		boolean result = false;
//
//		try {
//			entityTransaction.begin();
//
//			entityManager.persist(user);
//
//			entityTransaction.commit();
//
//			result = true;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//			System.out.println(e.getMessage());
//
//			entityTransaction.rollback();
//
//		} finally {
//
//			entityManager.close();
//
//		}
//
//		return result;

	}
}
