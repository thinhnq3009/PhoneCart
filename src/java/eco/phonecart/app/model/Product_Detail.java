package eco.phonecart.app.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the [Product Detail] database table.
 * 
 */
@Entity
@Table(name="[Product Detail]")
@NamedQuery(name="Product_Detail.findAll", query="SELECT p FROM Product_Detail p")
public class Product_Detail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pro_detail")
	private int idProDetail;

	@Column(name="pd_content")
	private String pdContent;

	//bi-directional many-to-one association to Detail
	@ManyToOne
	@JoinColumn(name="id_property")
	private Property detail;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product product;

	public Product_Detail() {
	}

	public int getIdProDetail() {
		return this.idProDetail;
	}

	public void setIdProDetail(int idProDetail) {
		this.idProDetail = idProDetail;
	}

	public String getPdContent() {
		return this.pdContent;
	}

	public void setPdContent(String pdContent) {
		this.pdContent = pdContent;
	}

	public Property getDetail() {
		return this.detail;
	}

	public void setDetail(Property detail) {
		this.detail = detail;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}