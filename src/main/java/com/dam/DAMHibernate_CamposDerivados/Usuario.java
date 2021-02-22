package com.dam.DAMHibernate_CamposDerivados;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
public class Usuario {
	
	@Id
	private String login;
	@ColumnTransformer(
			write=" MD5(?) "
	)
	private String password;
	@CreationTimestamp
	private Timestamp fechaAlta;
	@Generated(GenerationTime.INSERT)
	@Column(columnDefinition = " VARCHAR(30) AS (CONCAT(login,fechaAlta)) ")
	private String id;
	
	public Usuario(String login, String password) {
		this.login = login;
		this.password = password;

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
	
}
