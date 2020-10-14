package de.claus.footballmanager.model;

import java.util.ArrayList;
import java.util.List;

import de.claus.footballmanager.entities.ClubEntity;
import de.claus.footballmanager.entities.TeamEntity;

public class Club {
	private int id;
	private String name;
	private List<Team> teams;
	
	public Club(ClubEntity entity) {
		id = entity.getId();
		name = entity.getName();
		
		if(entity.getTeams() != null) {
			teams = new ArrayList<Team>();
			for(TeamEntity teamentity: entity.getTeams()) {
				teams.add(new Team(teamentity));
			}
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Team> getTeams() {
		return teams;
	}
	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

}
