package com.skyline.database.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owner_seq_gen")
	@SequenceGenerator(name = "owner_seq_gen", sequenceName = "owner_id_seq", allocationSize = 1)
	@Column(name = "owner_id")
	private Integer ownerId;
	
	@Column(name = "login")
	private String login;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "active")
	private Boolean active;
	
	
	public Integer getOwnerId() {
		return ownerId;
	}
	
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean getActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}
}