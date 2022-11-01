package eco.phonecart.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import eco.phonecart.app.model.Category;
import eco.phonecart.app.utils.JpaUtils;

public class CategoryDao {

	public List<Category> getAll() throws Exception {

		EntityManager entityManager = JpaUtils.getEntityManager();

		String sql = "SELECT c FROM Category c";

		TypedQuery<Category> query = entityManager.createQuery(sql, Category.class);

		return query.getResultList();

	}

	public Category findByID(int idCategory) throws Exception {
		EntityManager entityManager = JpaUtils.getEntityManager();

		String sql = "SELECT c FROM Category c WHERE idCategory = :id";

		TypedQuery<Category> query = entityManager.createQuery(sql, Category.class);

		query.setParameter("id", idCategory);
		
		return query.getSingleResult();
	}

}
