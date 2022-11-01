package eco.phonecart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Company database table.
 * 
 */
@Entity
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
public class Company implements Serializable {
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

}