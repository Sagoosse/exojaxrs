package fr.epsi;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PersonDao {
	
	@PersistenceContext(unitName="exo")
	private EntityManager entityManager;

	public List<Person> getAll(){
		// synthaxe JPQL
		return entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList();
	}

	public void create(Person person){
		entityManager.persist(person);
	}

	public Person get(long id) {
		return entityManager.find(Person.class, id);
	}

	public void delete(long id){
		entityManager.createQuery("delete from Person p where p.id = :idParam").setParameter("idParam", id).executeUpdate();
	}
}

