package de.claus.footballmanager.resources;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.claus.footballmanager.model.Club;
import de.claus.footballmanager.model.Team;
import de.claus.footballmanager.services.ClubService;

@ApplicationScoped
@Path("clubs")
public class ClubResource {
	@Inject
	private ClubService clubservice;
   	@POST
   	@Produces(MediaType.APPLICATION_JSON)
   	public Response createClub(@QueryParam ("name") String name) {
   		Club club = clubservice.createClub(name);
   		return Response
				.ok(club)//TODO Club erstellen
				.build();
   	}
   	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllClubs() {
   		List<Club> list = clubservice.getAllClubs();
   		return Response
				.ok(list)//TODO Club zurueckgeben
				.build();
   	}
}
