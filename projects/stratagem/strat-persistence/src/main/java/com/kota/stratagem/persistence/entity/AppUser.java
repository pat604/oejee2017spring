package com.kota.stratagem.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.kota.stratagem.persistence.parameter.AppUserParameter;
import com.kota.stratagem.persistence.parameter.ProjectParameter;
import com.kota.stratagem.persistence.query.AppUserQuery;
import com.kota.stratagem.persistence.query.ProjectQuery;

@Entity
@Table(name = "app_users")
@NamedQueries(value = { //
		@NamedQuery(name = AppUserQuery.COUNT_BY_ID, query = "SELECT COUNT(u) FROM AppUser u WHERE u.id=:" + AppUserParameter.ID),
		@NamedQuery(name = AppUserQuery.GET_ALL_USERS, query = "SELECT u FROM AppUser u ORDER BY u.name"),
		@NamedQuery(name = AppUserQuery.GET_BY_ID, query = "SELECT u FROM AppUser u WHERE u.id=:" + AppUserParameter.ID),
		@NamedQuery(name = AppUserQuery.REMOVE_BY_ID, query = "DELETE FROM AppUser u WHERE u.id=:" + AppUserParameter.ID)
		//
})
public class AppUser implements Serializable {

	private static final long serialVersionUID = -2320296399311475905L;
	
	@Id
	//@SequenceGenerator(name = "appUsertGenerator", sequenceName = "project_project_id_seq", allocationSize = 1)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appUsertGenerator")
	@Column(name = "user_id", nullable = false, updatable = false, insertable = false)
	private Long id;
	
	@Column(name = "user_name", nullable = false)
	private String name;
}
