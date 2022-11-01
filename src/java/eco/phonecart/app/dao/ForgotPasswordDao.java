package eco.phonecart.app.dao;

import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import eco.phonecart.app.helper.DatabaseHelper;
import eco.phonecart.app.model.ForgotPassword;
import eco.phonecart.app.utils.JpaUtils;

public class ForgotPasswordDao {

	public boolean insert(ForgotPassword f) throws Exception {
		return DatabaseHelper.insert(f);
	}

	public ForgotPassword find(ForgotPassword f) throws Exception {

		EntityManager entityManager = JpaUtils.getEntityManager();

		String sql = "SELECT f FROM Forgot_Password f WHERE id_user = :user AND resert_code = :code";

		TypedQuery<ForgotPassword> query = entityManager.createQuery(sql, ForgotPassword.class);

		query.setParameter("user", f.getUser());
		query.setParameter("code", f.getResertCode());

		return query.getSingleResult();

	}

	
	/**
	 * 
	 * @param username
	 * @param resetCode
	 * @return 1: resetCode is correct and valid
	 * 		   0: resetCode is correct and invalid 
 * 			   -1: resetCode is incorrect
	 * 	
	 * 
	 * @throws Exception
	 */
	public int verify(String username, String resetCode) throws Exception {

		EntityManager entityManager = JpaUtils.getEntityManager();

		String sql = "SELECT f FROM ForgotPassword f WHERE f.user.username = :user AND resert_code = :code";

		TypedQuery<ForgotPassword> query = entityManager.createQuery(sql, ForgotPassword.class);

		query.setParameter("user", username);
		query.setParameter("code", resetCode);

		ForgotPassword f = query.getSingleResult();

		if (f == null)
			return -1;

		/*
		 * if result < 1 this code is valid
		 */
		Timestamp now = new Timestamp(System.currentTimeMillis());
		int result = now.compareTo(f.getTimeActive());

		return result < 1 ? 1 : 0;

	}

}
