package eco.phonecart.app.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import eco.phonecart.app.model.Admin;
import eco.phonecart.app.utils.JpaUtils;


public class AdminDao {

	private final List<Admin> gets(String username, boolean findAll) throws Exception {

		EntityManager entityManager = JpaUtils.getEntityManager();

		String sql = "SELECT a FROM Admin a WHERE username = :username OR 1 = :findAll";

		TypedQuery<Admin> query = entityManager.createQuery(sql, Admin.class);

		query.setParameter("username", username);
		query.setParameter("findAll", findAll ? 1 : 0);

		return query.getResultList();

	}

	public List<Admin> gets() throws Exception {

		return gets("", true);

	}

	public Admin get(String username) throws Exception {
		List<Admin> list = gets(username, false);

		return list.isEmpty() ? null : list.get(0);
	}

	public boolean update(Admin admin) throws Exception {

		boolean result = true;
		
		try {
			
			EntityManager entityManager = JpaUtils.getEntityManager();
			
			EntityTransaction entityTransaction = entityManager.getTransaction();
			
			try {
				
				entityTransaction.begin();
				
				entityManager.merge(admin);
				
				entityTransaction.commit();
				
				result = false;
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
				entityTransaction.rollback();
				
				result = false;
			} finally {
				
				entityManager.close();
			}
			
			
		} catch (Exception e) {
			throw e;
		}

		return result;
		
			
	}

	public Admin getByRememberCode(String rememberCode) {
		
		EntityManager entityManager = JpaUtils.getEntityManager();
		
		String sql = "SELECT a FROM Admin a WHERE remember = :remember";
		
		TypedQuery<Admin> query = entityManager.createQuery(sql, Admin.class);
		
		query.setParameter("remember", rememberCode);
		
		return query.getSingleResult();
		
		
	}

}
