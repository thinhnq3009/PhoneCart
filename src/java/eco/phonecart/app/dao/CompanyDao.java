package eco.phonecart.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import eco.phonecart.app.model.Company;
import eco.phonecart.app.utils.JpaUtils;

public class CompanyDao {

	private List<Company> get(String companyName, boolean getAll) throws Exception {

		EntityManager entityManager = JpaUtils.getEntityManager();

		String sql = "SELECT c FROM Company c WHERE com_name = :companyName or 1 = :getAll";

		TypedQuery<Company> query = entityManager.createQuery(sql, Company.class);

		query.setParameter("companyName", companyName);
		query.setParameter("getAll", getAll ? 1 : 0);

		return query.getResultList();

	}

	public List<Company> getAll() throws Exception {
		return get("", true);
	}

	public Company findByID(int idCompany) {
		EntityManager entityManager = JpaUtils.getEntityManager();

		String sql = "SELECT c FROM Company c WHERE idCompany = :id";

		TypedQuery<Company> query = entityManager.createQuery(sql, Company.class);
		
		query.setParameter("id", idCompany);
		
		return query.getSingleResult();
	}

}
