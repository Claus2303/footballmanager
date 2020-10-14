package de.claus.footballmanager.resources;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import de.claus.footballmanager.model.Team;
import de.claus.footballmanager.services.TeamService;

@ApplicationScoped
@Path("teams")
public class TeamResource {
	@Inject
	private TeamService teamservice;
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
	   	public Response createTeam(@QueryParam ("clubid") int clubid, @QueryParam ("name") String name) {
	   		Team team = teamservice.createTeam(clubid, name);
	   		return Response
    				.ok(team)//TODO Team erstellen
    				.build();
	   	}
	   	
	   	@GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response getTeams() {
	   		List<Team> list = teamservice.getAllTeams();
	   		return Response
    				.ok(list)//TODO Team zurueckgeben
    				.build();
	   	}
	   	
}
