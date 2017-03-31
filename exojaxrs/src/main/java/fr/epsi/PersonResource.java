package fr.epsi;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class PersonResource {
	
	private PersonDao personDao;
	private final long id;
	
	
	public PersonResource(PersonDao personDao, long id) {
		this.personDao = personDao;
		this.id = id;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Person getPerson() {

		Person person = personDao.get(id);
		if (person == null) {
			throw new NotFoundException();
		}
		return person;
	}

	@DELETE
	public void deletePerson(){
		personDao.delete(id);
	}

}
