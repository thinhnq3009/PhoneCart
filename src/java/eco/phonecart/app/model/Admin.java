package eco.phonecart.app.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

import javax.persistence.*;

import org.json.simple.JSONObject;

import eco.phonecart.app.interfaces.EntityToJSON;
import eco.phonecart.app.interfaces.EntityPrivateData;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Admin database table.
 * 
 */
@Entity
@NamedQuery(name="Admin.findAll", query="SELECT a FROM Admin a")
public class Admin implements Serializable, EntityToJSON, EntityPrivateData {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_admin")
	private int idAdmin;

	@Column(name="account_name")
	private String accountName;

	@Column(name="admin_avata")
	private String adminAvata;

	private String email;

	private String password;

	private String phone;

	private String remember;

	@Column(name="super_admin")
	private boolean superAdmin;

	private String username;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="admin")
	private List<Product> products;

	//bi-directional many-to-one association to Vouncher
	@OneToMany(mappedBy="admin")
	private List<Vouncher> vounchers;

	public Admin() {
	}

	public int getIdAdmin() {
		return this.idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAdminAvata() {
		return this.adminAvata;
	}

	public void setAdminAvata(String adminAvata) {
		this.adminAvata = adminAvata;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemember() {
		return this.remember;
	}

	public void setRemember(String remember) {
		this.remember = remember;
	}

	public boolean getSuperAdmin() {
		return this.superAdmin;
	}

	public void setSuperAdmin(boolean superAdmin) {
		this.superAdmin = superAdmin;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setAdmin(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setAdmin(null);

		return product;
	}

	public List<Vouncher> getVounchers() {
		return this.vounchers;
	}

	public void setVounchers(List<Vouncher> vounchers) {
		this.vounchers = vounchers;
	}

	public Vouncher addVouncher(Vouncher vouncher) {
		getVounchers().add(vouncher);
		vouncher.setAdmin(this);

		return vouncher;
	}

	public Vouncher removeVouncher(Vouncher vouncher) {
		getVounchers().remove(vouncher);
		vouncher.setAdmin(null);

		return vouncher;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toJSON() {
		JSONObject result = new JSONObject();

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
					result.put(f.getName(), new SimpleDateFormat("dd-MM-YY").format(d));
				} else if (o instanceof EntityToJSON e) {
					result.put(f.getName(), e.toJSON());
				} else {
					result.put(f.getName(), "undefined");
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return result.toString();
	}

	
	@Override
	public int getID() {
		return getIdAdmin();
	}
}