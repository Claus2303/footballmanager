package de.claus.footballmanager.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import de.claus.footballmanager.entities.ClubEntity;
import de.claus.footballmanager.entities.TeamEntity;
import de.claus.footballmanager.model.Club;
import de.claus.footballmanager.repositories.ClubRepository;
@ApplicationScoped
@Transactional
public class ClubService {
	@Inject
	private ClubRepository<ClubEntity, TeamEntity> clubrepository;
	
	public Club createClub(String name){
		//Validate.notNull(Team team,"Team must not be null");
		
		ClubEntity e = clubrepository.createClub(name);
		return new Club(e);
	}
	/**
	 * 
	 * @return
	 */
	public List<Club> getAllClubs(){
	
		List<Club> clublist = clubrepository.getAllClubs().stream()
		.map(Club::new) //--> das geht wegen dem Konstruktor Club(ClubEntity p)
		.collect(Collectors.toList());
		
		return clublist;
	}
}
