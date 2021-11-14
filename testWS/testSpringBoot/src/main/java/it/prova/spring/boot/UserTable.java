package it.prova.spring.boot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserTable {
	private @Id @GeneratedValue Integer userId;
	private String cognome;
	private String nome;
	private String password;

	public UserTable() {

	}

	public UserTable(String cognome, String nome, String password) {
		super();
		this.cognome = cognome;
		this.nome = nome;
		this.password = password;
	}

}
