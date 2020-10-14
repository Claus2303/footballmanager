package de.claus.footballmanager.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name= "ClubEntity.findAll", query = "select e from ClubEntity e")
public class ClubEntity {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private List<TeamEntity> teams;
	
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
	public List<TeamEntity> getTeams() {
		return teams;
	}
	public void setTeams(List<TeamEntity> teams) {
		this.teams = teams;
	}
}
