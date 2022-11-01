package eco.phonecart.app.model;

import java.io.Serializable;
import javax.persistence.*;

import org.json.simple.JSONObject;

import eco.phonecart.app.dao.ProductDetailDao;
import eco.phonecart.app.helper.JSONHelper;
import eco.phonecart.app.interfaces.EntityToJSON;
import eco.phonecart.app.interfaces.IdEntity;

import java.lang.reflect.Field;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * The persistent class for the Product database table.
 * 
 */
@Entity
@NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
public class Product implements Serializable, EntityToJSON {
	/**
	 * 
	 */
	private static final long serialVersionUID = -462773988814760796L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")
	private int idProduct;

	@Column(name = "pro_describle")
	private String proDescrible;

	@Column(name = "pro_image")
	private String proImage;

	@Column(name = "pro_name")
	private String proName;

	@Column(name = "pro_price")
	private Long proPrice;

	@Column(name = "pro_quatity")
	private int proQuatity;

	@Column(name = "pro_sold")
	private int proSold;

	@Column(name = "pro_time_create")
	private Timestamp proTimeCreate;

	// bi-directional many-to-one association to Admin
	@ManyToOne
	@JoinColumn(name = "id_admin")
	private Admin admin;

	// bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name = "id_category")
	private Category category;

	// bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name = "id_company")
	private Company company;

	// bi-directional many-to-one association to Cart
	@OneToMany(mappedBy = "product")
	private List<Cart> carts;

	// bi-directional many-to-one association to Order_Detail
	@OneToMany(mappedBy = "product")
	private List<Order_Detail> orderDetails;

	// bi-directional many-to-one association to Product_Detail
	@OneToMany(mappedBy = "product")
	private List<Product_Detail> productDetails;

	// bi-directional many-to-one association to Wish_List
	@OneToMany(mappedBy = "product")
	private List<Wish_List> wishLists;

	public Product() {
	}

	public Long getProPrice() {
		return proPrice == null ? 0 : proPrice;
	}

	public void setProPrice(Long proPrice) {
		this.proPrice = proPrice;
	}

	public int getIdProduct() {
		return this.idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public String getProDescrible() {
		return this.proDescrible;
	}

	public void setProDescrible(String proDescrible) {
		this.proDescrible = proDescrible;
	}

	public String getProImage() {
		return this.proImage;
	}

	public void setProImage(String proImage) {
		this.proImage = proImage;
	}

	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public int getProQuatity() {
		return this.proQuatity;
	}

	public void setProQuatity(int proQuatity) {
		this.proQuatity = proQuatity;
	}

	public int getProSold() {
		return this.proSold;
	}

	public void setProSold(int proSold) {
		this.proSold = proSold;
	}

	public Timestamp getProTimeCreate() {
		return this.proTimeCreate;
	}

	public void setProTimeCreate(Timestamp proTimeCreate) {
		this.proTimeCreate = proTimeCreate;
	}

	public Admin getAdmin() {
		return this.admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setProduct(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setProduct(null);

		return cart;
	}

	public List<Order_Detail> getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(List<Order_Detail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Order_Detail addOrderDetail(Order_Detail orderDetail) {
		getOrderDetails().add(orderDetail);
		orderDetail.setProduct(this);

		return orderDetail;
	}

	public Order_Detail removeOrderDetail(Order_Detail orderDetail) {
		getOrderDetails().remove(orderDetail);
		orderDetail.setProduct(null);

		return orderDetail;
	}

	public List<Product_Detail> getProductDetails() {
		return this.productDetails;
	}

	public void setProductDetails(List<Product_Detail> productDetails) {
		this.productDetails = productDetails;
	}

	public Product_Detail addProductDetail(Product_Detail productDetail) {
		getProductDetails().add(productDetail);
		productDetail.setProduct(this);

		return productDetail;
	}

	public Product_Detail removeProductDetail(Product_Detail productDetail) {
		getProductDetails().remove(productDetail);
		productDetail.setProduct(null);

		return productDetail;
	}

	public List<Wish_List> getWishLists() {
		return this.wishLists;
	}

	public void setWishLists(List<Wish_List> wishLists) {
		this.wishLists = wishLists;
	}

	public Wish_List addWishList(Wish_List wishList) {
		getWishLists().add(wishList);
		wishList.setProduct(this);

		return wishList;
	}

	public Wish_List removeWishList(Wish_List wishList) {
		getWishLists().remove(wishList);
		wishList.setProduct(null);

		return wishList;
	}

	@SuppressWarnings("unchecked")
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
				} else if (o instanceof IdEntity id) {
					result.put(f.getName(), id.getID());
				} else if (o instanceof EntityToJSON e) {
					result.putJSON(f.getName(), e.toJSON());
				} else {
					result.put(f.getName(), "undefined");
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return result.toString();
	}

	public void addProperty(Property detail, String content) throws Exception {
		new ProductDetailDao().add(this, detail, content);
	}

}