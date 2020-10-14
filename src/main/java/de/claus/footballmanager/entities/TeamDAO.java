package de.claus.footballmanager.entities;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.claus.footballmanager.repositories.TeamRepository;
@Default
@RequestScoped
public class TeamDAO implements TeamRepository<TeamEntity>{
	@PersistenceContext(unitName="footballmanagers")
	private EntityManager em;
	/**
	 * Erzeugt ein Team. Die ID dazu wird von der DB generiert
	 */
	public TeamEntity createTeam(int clubid, String name) {
		TeamEntity entity = null;
		ClubEntity clubentity = em.find(ClubEntity.class, clubid);
		if(clubentity != null) {
			em.getTransaction().begin();
			entity = new TeamEntity();
			entity.setName(name);
			em.persist(entity);
			
			clubentity.getTeams().add(entity);
			em.persist(clubentity);
			em.getTransaction().commit();
		}
		return entity;
	}
	/**
	 * Gibt alle Mannschaften zurück
	 */
	public List<TeamEntity> getTeams() {
		TypedQuery<TeamEntity> query = em.createNamedQuery("TeamEntity.findAll",TeamEntity.class);
		return query.getResultList();
	}
}
