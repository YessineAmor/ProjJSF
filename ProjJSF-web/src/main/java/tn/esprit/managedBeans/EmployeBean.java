package tn.esprit.managedBeans;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import myentities.Employe;
import myentities.Role;
import servicesimpl.EmployeService;

@ManagedBean(name = "employeBean")
@SessionScoped
public class EmployeBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String password;
	private String email;
	private Boolean isActif;
	private Role role;
	private Employe selectedEmploye;

	@EJB
	EmployeService employeService;

	public void addEmploye() {
		employeService.ajouterEmploye(new Employe(login, password, email, isActif, role));
	}

	public Employe getSelectedEmploye() {
		return selectedEmploye;
	}

	public void setSelectedEmploye(Employe selectedEmploye) {
		this.selectedEmploye = selectedEmploye;
	}

	// getters & setters
	private List<Employe> employes;

	public List<Employe> getEmployes() {
		employes = employeService.getAllEmployes();
		return employes;
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

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public EmployeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public void deleteEmploye(Employe e) {
		employeService.deleteEmploye(e);
	}

	public String initEdit(Employe e) {
		this.selectedEmploye = e;
		return "/pages/admin/editEmploye?faces-redirect=true";
	}

	public String editEmployee(Employe e) {
		employeService.editEmploye(e);
		return "/pages/admin/welcome?faces-redirect=true";
	}

	public void editInSamePage(Employe e) {
		this.selectedEmploye = e;
	}

}
