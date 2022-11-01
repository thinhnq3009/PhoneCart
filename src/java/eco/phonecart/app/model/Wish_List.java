package eco.phonecart.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Wish_List database table.
 * 
 */
@Entity
@NamedQuery(name="Wish_List.findAll", query="SELECT w FROM Wish_List w")
public class Wish_List implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_wish_list")
	private int idWishList;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product product;

	//bi-directional many-to-one association to Users
	@ManyToOne
	@JoinColumn(name="id_user")
	private Users user;

	public Wish_List() {
	}

	public int getIdWishList() {
		return this.idWishList;
	}

	public void setIdWishList(int idWishList) {
		this.idWishList = idWishList;
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

}