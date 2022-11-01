package eco.phonecart.app.model;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.persistence.*;

import eco.phonecart.app.helper.JSONHelper;
import eco.phonecart.app.interfaces.EntityPrivateData;
import eco.phonecart.app.interfaces.EntityToJSON;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Company database table.
 * 
 */
@Entity
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable, EntityToJSON {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_company")
	private int idCompany;

	@Column(name="com_logo")
	private String comLogo;

	@Column(name="com_name")
	private String comName;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="company")
	private List<Product> products;

	public Company() {
	}

	public int getIdCompany() {
		return this.idCompany;
	}

	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}

	public String getComLogo() {
		return this.comLogo;
	}

	public void setComLogo(String comLogo) {
		this.comLogo = comLogo;
	}

	public String getComName() {
		return this.comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setCompany(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCompany(null);

		return product;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toJSON() {
		JSONHelper result = new JSONHelper();

		Field[] fields = this.getClass().getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];

			try {

				Object o = f.get(this);

				if (o instanceof String s) {
					result.put(f.getName(), s);
				} else if (o instanceof Number n) {
					result.put(f.getName(), n);
				} else if (o instanceof Date d) {
					result.put(f.getName(), d.toString());
				} else if (o instanceof EntityPrivateData id) {
					result.put(f.getName(), id.getID());
				} else if (o instanceof EntityToJSON e) {
					result.putJSON(f.getName(), e.toJSON());
				} else if (o instanceof List) {
					continue;
				} else {
					result.put(f.getName(), "undefined");
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return result.toString();
	}

}