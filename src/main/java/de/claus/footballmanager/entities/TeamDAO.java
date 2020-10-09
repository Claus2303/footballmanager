package de.claus.footballmanager.entities;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.claus.footballmanager.repositories.TeamRepository;

public class TeamDAO implements TeamRepository<TeamEntity>{
	@PersistenceContext(unitName="footballmanager")
	private EntityManager entitymanager;

	public TeamEntity createTeam(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
