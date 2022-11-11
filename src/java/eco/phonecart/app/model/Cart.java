package eco.phonecart.app.model;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import eco.phonecart.app.helper.JSONHelper;
import eco.phonecart.app.interfaces.EntityPrivateData;
import eco.phonecart.app.interfaces.EntityToJSON;


/**
 * The persistent class for the Cart database table.
 * 
 */
@Entity
@NamedQuery(name="Cart.findAll", query="SELECT c FROM Cart c")
public class Cart implements Serializable,EntityToJSON {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cart")
	private int idCart;

	private int quantity;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product product;

	//bi-directional many-to-one association to Users
	@ManyToOne
	@JoinColumn(name="id_user")
	private Users user;

	public Cart() {
	}

	public int getIdCart() {
		return this.idCart;
	}

	public void setIdCart(int idCart) {
		this.idCart = idCart;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
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