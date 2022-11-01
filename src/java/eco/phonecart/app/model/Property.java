package eco.phonecart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Detail database table.
 * 
 */
@Entity
@NamedQuery(name="Property.findAll", query="SELECT d FROM Property d")
public class Property implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_property")
	private int idProperty;

	@Column(name="de_property")
	private String deProperty;

	//bi-directional many-to-one association to Product_Detail
	@OneToMany(mappedBy="detail")
	private List<Product_Detail> productDetails;

	public Property() {
	}

	public int getIdProperty() {
		return this.idProperty;
	}

	public void setIdProperty(int idProperty) {
		this.idProperty = idProperty;
	}

	public String getProperty() {
		return this.deProperty;
	}

	public void setProperty(String deProperty) {
		this.deProperty = deProperty;
	}

	public List<Product_Detail> getProductDetails() {
		return this.productDetails;
	}

	public void setProductDetails(List<Product_Detail> productDetails) {
		this.productDetails = productDetails;
	}

	public Product_Detail addProductDetail(Product_Detail productDetail) {
		getProductDetails().add(productDetail);
		productDetail.setDetail(this);

		return productDetail;
	}

	public Product_Detail removeProductDetail(Product_Detail productDetail) {
		getProductDetails().remove(productDetail);
		productDetail.setDetail(null);

		return productDetail;
	}

}