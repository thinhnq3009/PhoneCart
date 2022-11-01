package eco.phonecart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the Vouncher database table.
 * 
 */
@Entity
@NamedQuery(name="Vouncher.findAll", query="SELECT v FROM Vouncher v")
public class Vouncher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_vouncher")
	private int idVouncher;

	private String code;

	private double discount;

	@Column(name="max_discount")
	private int maxDiscount;

	@Column(name="min_apply")
	private int minApply;

	@Column(name="time_created")
	private Timestamp timeCreated;

	@Column(name="time_used")
	private Timestamp timeUsed;

	@Column(name="vouncher_detail")
	private String vouncherDetail;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="vouncherBean")
	private List<Order> orders;

	//bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name="id_admin")
	private Admin admin;

	public Vouncher() {
	}

	public int getIdVouncher() {
		return this.idVouncher;
	}

	public void setIdVouncher(int idVouncher) {
		this.idVouncher = idVouncher;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getMaxDiscount() {
		return this.maxDiscount;
	}

	public void setMaxDiscount(int maxDiscount) {
		this.maxDiscount = maxDiscount;
	}

	public int getMinApply() {
		return this.minApply;
	}

	public void setMinApply(int minApply) {
		this.minApply = minApply;
	}

	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	public Timestamp getTimeUsed() {
		return this.timeUsed;
	}

	public void setTimeUsed(Timestamp timeUsed) {
		this.timeUsed = timeUsed;
	}

	public String getVouncherDetail() {
		return this.vouncherDetail;
	}

	public void setVouncherDetail(String vouncherDetail) {
		this.vouncherDetail = vouncherDetail;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setVouncherBean(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setVouncherBean(null);

		return order;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}