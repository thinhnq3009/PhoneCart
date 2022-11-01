package eco.phonecart.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Order_Detail database table.
 * 
 */
@Entity
@NamedQuery(name="Order_Detail.findAll", query="SELECT o FROM Order_Detail o")
public class Order_Detail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_order_detail")
	private int idOrderDetail;

	@Column(name="de_note")
	private String deNote;

	@Column(name="de_quatity")
	private int deQuatity;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="id_order")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product product;

	public Order_Detail() {
	}

	public int getIdOrderDetail() {
		return this.idOrderDetail;
	}

	public void setIdOrderDetail(int idOrderDetail) {
		this.idOrderDetail = idOrderDetail;
	}

	public String getDeNote() {
		return this.deNote;
	}

	public void setDeNote(String deNote) {
		this.deNote = deNote;
	}

	public int getDeQuatity() {
		return this.deQuatity;
	}

	public void setDeQuatity(int deQuatity) {
		this.deQuatity = deQuatity;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}