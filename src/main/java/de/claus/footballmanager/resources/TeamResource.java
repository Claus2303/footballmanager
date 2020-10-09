package de.claus.footballmanager.resources;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("teams")
public class TeamResource {
	   	@GET
	    @Path("id/{identifier: [0-9]}")
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getTeam(@PathParam ("id") String myID) {
	   		return Response
    				.ok()//TODO Team zurueckgeben
    				.build();
	   	}
	   	@POST
	   	@Produces(MediaType.APPLICATION_JSON)
	   	public Response createTeam(@QueryParam ("name") String name) {
	   		return Response
    				.ok()//TODO Team erstellen
    				.build();
	   	}
	   	
}
