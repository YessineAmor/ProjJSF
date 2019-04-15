package myentities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employe
 *
 */
@Entity
public class Employe implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String login;
	private String password;
	private String email;
	private boolean editable;

	// private Boolean isActif;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public Employe(String login, String password, String email, Boolean isActif, Role role) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		// this.isActif = isActif;
		this.role = role;
	}

	@Enumerated(EnumType.STRING)
	// @NotNull
	private Role role;

	public Employe() {
		super();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Employe(String login, String password, String email, Role role) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.role = role;
	}

}
