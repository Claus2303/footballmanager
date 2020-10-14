package de.claus.footballmanager.entities;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import de.claus.footballmanager.repositories.ClubRepository;

@Default
@RequestScoped
public class ClubDAO implements ClubRepository<ClubEntity, TeamEntity>{
	@PersistenceContext(unitName="footballmanagers")
	private EntityManager em;

	@Override
	public ClubEntity addTeam(int clubid, TeamEntity team) {
		ClubEntity clubentity = em.find(ClubEntity.class, clubid);
		if(clubentity != null) {
			clubentity.getTeams().add(team);
			em.persist(clubentity);
		}
		return clubentity;
	}

	@Override
	public ClubEntity createClub(String name) {
		ClubEntity entity = new ClubEntity();
		entity.setName(name);
		em.persist(entity);

		return entity;
	}

	@Override
	public List<ClubEntity> getAllClubs() {
		TypedQuery<ClubEntity> query = em.createNamedQuery("ClubEntity.findAll",ClubEntity.class);
		return query.getResultList();
	}
}
