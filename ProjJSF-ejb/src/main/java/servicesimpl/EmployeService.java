package servicesimpl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import myentities.Role;
import myentities.Employe;
import servicesinterf.EmployeServiceRemote;

@Stateless
@LocalBean
public class EmployeService implements EmployeServiceRemote {

	@PersistenceContext(unitName = "imputation-ejb")
	EntityManager em;

	public int ajouterEmploye() {
		Employe e = new Employe("Mohamed", "Ali", "Med@esprit.tn", Role.ADMINISTRATEUR);
		em.persist(e);
		return 1;
	}

	public void ajouterEmploye(Employe e) {
		em.persist(e);
	}

	public Employe getEmployeByEmailAndPassword(String login, String password) {

		TypedQuery<Employe> query = em
				.createQuery("select e from Employe e where e.login=:login AND e.password=:password", Employe.class);

		query.setParameter("login", login);
		query.setParameter("password", password);

		Employe employe = null;
		try {
			employe = query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Erreur : " + e);
		}
		return employe;
	}

	public List<Employe> getAllEmployes() {
		List<Employe> emp = em.createQuery("Select e from Employe e", Employe.class).getResultList();
		return emp;
	}

	public void deleteEmploye(Employe e) {
		em.remove(em.merge(e));
	}

}
