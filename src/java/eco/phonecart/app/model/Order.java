package eco.phonecart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Order database table.
 * 
 */
@Entity
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_order")
	private int idOrder;

	private int address;

	private boolean paid;

	private int payment;

	private short status;

	@Column(name="time_create")
	private Timestamp timeCreate;

	//bi-directional many-to-one association to Users
	@ManyToOne
	@JoinColumn(name="id_user")
	private Users user;

	//bi-directional many-to-one association to Vouncher
	@ManyToOne
	@JoinColumn(name="vouncher")
	private Vouncher vouncherBean;

	//bi-directional many-to-one association to Order_Detail
	@OneToMany(mappedBy="order")
	private List<Order_Detail> orderDetails;

	public Order() {
	}

	public int getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public int getAddress() {
		return this.address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public boolean getPaid() {
		return this.paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public int getPayment() {
		return this.payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public Timestamp getTimeCreate() {
		return this.timeCreate;
	}

	public void setTimeCreate(Timestamp timeCreate) {
		this.timeCreate = timeCreate;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Vouncher getVouncherBean() {
		return this.vouncherBean;
	}

	public void setVouncherBean(Vouncher vouncherBean) {
		this.vouncherBean = vouncherBean;
	}

	public List<Order_Detail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<Order_Detail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Order_Detail addOrderDetail(Order_Detail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setOrder(this);

		return orderDetail;
	}

	public Order_Detail removeOrderDetail(Order_Detail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setOrder(null);

		return orderDetail;
	}

}