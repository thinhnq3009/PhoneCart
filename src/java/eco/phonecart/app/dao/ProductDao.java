package eco.phonecart.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import eco.phonecart.app.helper.DatabaseHelper;
import eco.phonecart.app.model.Product;
import eco.phonecart.app.utils.JpaUtils;

public class ProductDao {

	public boolean insert(Product product) throws Exception {

		return DatabaseHelper.insert(product);

	}

	public List<Product> getAll() throws Exception {
		EntityManager entityManager = JpaUtils.getEntityManager();

		String sql = "SELECT p FROM Product p";

		TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);

		return query.getResultList();

	}

	public Product findById(int idProduct) {
		EntityManager entityManager = JpaUtils.getEntityManager();

		String sql = "SELECT p FROM Product p WHERE p.idProduct = :idProduct";

		TypedQuery<Product> query = entityManager.createQuery(sql, Product.class);

		query.setParameter("idProduct", idProduct);
		
		return query.getSingleResult();

	}

	public boolean update(Product product) throws Exception {
		return DatabaseHelper.update(product);
		
	}

	public boolean delete(Product product) throws Exception {
		return DatabaseHelper.delete(product);
		
	}
}
