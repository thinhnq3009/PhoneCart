package eco.phonecart.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import eco.phonecart.app.model.Property;
import eco.phonecart.app.utils.JpaUtils;

public class DetailDao {
	public Property findById(int id) throws Exception{
		EntityManager entityManager = JpaUtils.getEntityManager();
		
		String sql = "SELECT d FROM Detail d WHERE idDetail = :id";
		
		TypedQuery<Property> query = entityManager.createQuery(sql, Property.class);
		
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}
}
