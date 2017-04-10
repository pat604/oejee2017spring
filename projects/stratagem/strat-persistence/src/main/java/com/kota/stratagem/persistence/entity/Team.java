package com.kota.stratagem.persistence.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kota.stratagem.persistence.parameter.TeamParameter;
import com.kota.stratagem.persistence.query.TeamQuery;

@Entity
@Table(name = "teams")
@NamedQueries(value = { //
		@NamedQuery(name = TeamQuery.COUNT_BY_ID, query = "SELECT COUNT(t) FROM Team t WHERE t.id=:" + TeamParameter.ID),
		@NamedQuery(name = TeamQuery.GET_ALL_TEAMS, query = "SELECT t FROM Team t ORDER BY t.name"),
		@NamedQuery(name = TeamQuery.GET_BY_ID, query = "SELECT t FROM Team t WHERE t.id=:" + TeamParameter.ID),
		@NamedQuery(name = TeamQuery.REMOVE_BY_ID, query = "DELETE FROM Team t WHERE t.id=:" + TeamParameter.ID)
		//
})
@SequenceGenerator(name = "teamGenerator", sequenceName = "teams_team_id_seq", allocationSize = 1)
public class Team implements Serializable {

	private static final long serialVersionUID = -3554913763648115162L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teamGenerator")
	@Column(name = "team_id", nullable = false)
	private Long id;

	@Column(name = "team_name", nullable = false)
	private String name;

	@Column(name = "team_leader", nullable = false)
	private AppUser leader;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = AppUser.class)
	@JoinTable(name = "team_members", joinColumns = @JoinColumn(name = "team_member_user_id"), inverseJoinColumns = @JoinColumn(name = "team_member_team_id"))
	private Set<AppUser> members;

	public Team() {
		this.members = new HashSet<>();
	}

	public Team(Long id, String name, AppUser leader, Set<AppUser> members) {
		this.id = id;
		this.name = name;
		this.leader = leader;
		this.members = members;
	}

	public Team(String name, AppUser leader, Set<AppUser> members) {
		super();
		this.name = name;
		this.leader = leader;
		this.members = members;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AppUser getLeader() {
		return leader;
	}

	public void setLeader(AppUser leader) {
		this.leader = leader;
	}

	public Set<AppUser> getMembers() {
		return members;
	}

	public void setMembers(Set<AppUser> members) {
		this.members = members;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", leader=" + leader + ", members=" + members + "]";
	}

}
