package de.claus.footballmanager.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import de.claus.footballmanager.entities.TeamEntity;
import de.claus.footballmanager.model.Team;
import de.claus.footballmanager.repositories.TeamRepository;

@ApplicationScoped
@Transactional
public class TeamService {
	@Inject
	private TeamRepository<TeamEntity> teamrepository;
	
	public Team createTeam(Team team){
		//Validate.notNull(Team team,"Team must not be null");
		
		TeamEntity e = teamrepository.createTeam(team.getName());
		return e.apply(e);
	}
}
