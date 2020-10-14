package de.claus.footballmanager.services;

import java.util.List;
import java.util.stream.Collectors;

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
	
	public Team createTeam(int clubid, String name){
		//Validate.notNull(Team team,"Team must not be null");
		
		TeamEntity e = teamrepository.createTeam(clubid, name);
		return new Team(e);
	}
	/**
	 * 
	 * @return
	 */
	public List<Team> getAllTeams(){
	
		List<Team> dtolist = teamrepository.getTeams().stream()
		.map(Team::new) //--> das geht wegen dem Konstruktor PartnerDTO(PartnerEntity p)
		.collect(Collectors.toList());
		
		return dtolist;
	}
}
