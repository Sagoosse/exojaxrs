package fr.epsi;

import java.net.URI;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/person")
public class ListPersonResource {
	
	
	@EJB
	private PersonDao personDao;
	
	@Path("/{id}")
	public PersonResource getPersonResource(@PathParam("id") long id) {
		return new PersonResource(personDao, id);
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Person> getAll(@Context UriInfo uriInfo) {
		return personDao.getAll();
	}

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Response create(@FormParam("prenom") String prenom, @FormParam("nom") String nom, @FormParam("age") int age,
							@Context UriInfo uriInfo) {
		Person person = new Person();
		person.setAge(age);
		person.setNom(nom);
		person.setPrenom(prenom);
		
		personDao.create(person);
		URI newUri = uriInfo.getRequestUriBuilder().path(String.valueOf(person.getId())).build();
		return Response.created(newUri).entity(person).build();
	}

}
