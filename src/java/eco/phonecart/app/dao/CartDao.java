package eco.phonecart.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import eco.phonecart.app.model.Cart;
import eco.phonecart.app.model.Product;
import eco.phonecart.app.model.Users;
import eco.phonecart.app.utils.JpaUtils;

public class CartDao {
	public List<Cart> getAll(int userId) throws Exception{
		EntityManager em = JpaUtils.getEntityManager();
		
		String jstl = "SELECT c FROM Cart c WHERE c.user.idUser = :id";
		
		TypedQuery<Cart> query = em.createQuery(jstl, Cart.class);
		
		query.setParameter("id", userId);
		
		return query.getResultList();
		
	}
	
	public List<Cart> getAll(Users user) throws Exception {
		return getAll(user.getIdUser());
	}
	
	public boolean addCart(Users user, Product product, int quantity) {
		return true;
	}
	

	
}
