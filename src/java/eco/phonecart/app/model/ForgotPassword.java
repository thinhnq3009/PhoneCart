package eco.phonecart.app.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;



/**
 * The persistent class for the [Forgot Password] database table.
 * 
 */
@Entity
@Table(name="[ForgotPassword]")
@NamedQuery(name="Forgot_Password.findAll", query="SELECT f FROM ForgotPassword f")
public class ForgotPassword implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final int minuteEnable = 15;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_forget")
	private int idForget;

	@Column(name="resert_code")
	private String resertCode;

	@Column(name="time_active")
	private Timestamp timeActive;

	//bi-directional many-to-one association to Users
	@ManyToOne
	@JoinColumn(name="id_user")
	private Users user;

	public ForgotPassword() {
		setTimeActive(null);
	}

	public int getIdForget() {
		return this.idForget;
	}

	public void setIdForget(int idForget) {
		this.idForget = idForget;
	}

	public String getResertCode() {
		return this.resertCode;
	}

	public void setResertCode(String resertCode) {
		this.resertCode = resertCode;
	}

	public Timestamp getTimeActive() {
		return this.timeActive;
	}

	public void setTimeActive(Timestamp timeActive) {
		this.timeActive = createTime();
	}

	@SuppressWarnings("deprecation")
	private Timestamp createTime() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		int m = timestamp.getMinutes();
		
		if (m + minuteEnable < 60) {
			timestamp.setMinutes(m + minuteEnable);
		} else {
			timestamp.setHours(timestamp.getHours() + 1);
			timestamp.setMinutes(m + minuteEnable - 60);
		}
		
		return timestamp;
	}

	public Users getUser() {
		return this.user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

}