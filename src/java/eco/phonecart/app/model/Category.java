package eco.phonecart.app.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import eco.phonecart.app.helper.JSONHelper;
import eco.phonecart.app.interfaces.EntityPrivateData;
import eco.phonecart.app.interfaces.EntityToJSON;


/**
 * The persistent class for the Category database table.
 * 
 */
@Entity
@NamedQuery(name="Category.findAll", query="SELECT c FROM Category c")
public class Category implements Serializable, EntityToJSON {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_category")
	private int idCategory;

	@Column(name="image_category")
	private String imageCategory;

	@Column(name="name_category")
	private String nameCategory;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="category")
	private List<Product> products;

	public Category() {
	}

	public int getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getImageCategory() {
		return this.imageCategory;
	}

	public void setImageCategory(String imageCategory) {
		this.imageCategory = imageCategory;
	}

	public String getNameCategory() {
		return this.nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setCategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCategory(null);

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