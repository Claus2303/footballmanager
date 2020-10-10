package de.claus.footballmanager.repositories;

import java.util.List;

public interface TeamRepository <T>{

	/**
	 * Erzeugt ein Team
	 * @param name
	 * @return
	 */
	public T createTeam(String name);
	/**
	 * Gibt alle Teams aus
	 * @return
	 */
	public List<T> getTeams();
}
