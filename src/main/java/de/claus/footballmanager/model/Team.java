package de.claus.footballmanager.model;

import java.util.List;

public class Team {
	private int id;
	private String name;
	private List<TeamMember> teammembers;
	private List<Appointment> appointments;

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
	public List<TeamMember> getTeammembers() {
		return teammembers;
	}
	public void setTeammembers(List<TeamMember> teammembers) {
		this.teammembers = teammembers;
	}
	public List<Appointment> getAppointments() {
		return appointments;
	}
	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
}
