package servicesinterf;

import java.util.List;

import javax.ejb.Remote;

import myentities.Employe;
@Remote
public interface EmployeServiceRemote {

	public int ajouterEmploye();
	public Employe getEmployeByEmailAndPassword(String email, String password);
	public void ajouterEmploye(Employe e);
	public List<Employe> getAllEmployes();
	
}


