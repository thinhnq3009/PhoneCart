package eco.phonecart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@NamedQuery(name="Users.findAll", query="SELECT u FROM Users u")
public class Users implements Serializable, eco.phonecart.app.interfaces.CheckerInterface {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_user")
	private int idUser;

	@Column(name="account_name")
	private String accountName;

	private String avata;

	private String email;

	private String password;

	@Column(name="phone_number")
	private String phoneNumber;

	private String remember;

	private String username;

	//bi-directional many-to-one association to Address
	@OneToMany(mappedBy="user")
	private List<Address> addresses;

	//bi-directional many-to-one association to Cart
	@OneToMany(mappedBy="user")
	private List<Cart> carts;

	//bi-directional many-to-one association to Forgot_Password
	@OneToMany(mappedBy="user")
	private List<ForgotPassword> forgotPasswords;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="user")
	private List<Order> orders;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="default_address")
	private Address address;

	//bi-directional many-to-one association to Wish_List
	@OneToMany(mappedBy="user")
	private List<Wish_List> wishLists;

	public Users() {
	}

	public int getIdUser() {
		return this.idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAvata() {
		return this.avata;
	}

	public void setAvata(String avata) {
		this.avata = avata;
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

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRemember() {
		return this.remember;
	}

	public void setRemember(String remember) {
		this.remember = remember;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Address addAddress(Address address) {
		getAddresses().add(address);
		address.setUser(this);

		return address;
	}

	public Address removeAddress(Address address) {
		getAddresses().remove(address);
		address.setUser(null);

		return address;
	}

	public List<Cart> getCarts() {
		return this.carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public Cart addCart(Cart cart) {
		getCarts().add(cart);
		cart.setUser(this);

		return cart;
	}

	public Cart removeCart(Cart cart) {
		getCarts().remove(cart);
		cart.setUser(null);

		return cart;
	}

	public List<ForgotPassword> getForgotPasswords() {
		return this.forgotPasswords;
	}

	public void setForgotPasswords(List<ForgotPassword> forgotPasswords) {
		this.forgotPasswords = forgotPasswords;
	}

	public ForgotPassword addForgotPassword(ForgotPassword forgotPassword) {
		getForgotPasswords().add(forgotPassword);
		forgotPassword.setUser(this);

		return forgotPassword;
	}

	public ForgotPassword removeForgotPassword(ForgotPassword forgotPassword) {
		getForgotPasswords().remove(forgotPassword);
		forgotPassword.setUser(null);

		return forgotPassword;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setUser(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setUser(null);

		return order;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Wish_List> getWishLists() {
		return this.wishLists;
	}

	public void setWishLists(List<Wish_List> wishLists) {
		this.wishLists = wishLists;
	}

	public Wish_List addWishList(Wish_List wishList) {
		getWishLists().add(wishList);
		wishList.setUser(this);

		return wishList;
	}

	public Wish_List removeWishList(Wish_List wishList) {
		getWishLists().remove(wishList);
		wishList.setUser(null);

		return wishList;
	}

	public String getHideEmail() {
		if (this.email == null || this.email.isBlank()) {
			return "";
		} else {
			return this.email.substring(0, 3) + "****" +this.email.substring(this.email.indexOf("@"));
		}
	}

}