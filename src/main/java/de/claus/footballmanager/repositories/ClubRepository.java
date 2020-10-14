package de.claus.footballmanager.repositories;

import java.util.List;

public interface ClubRepository <T, D>{
	
	public T addTeam(int clubid, D team);
	
	public T createClub(String name);
	
	public List<T> getAllClubs();

}
