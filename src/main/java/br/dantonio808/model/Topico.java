package br.dantonio808.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Diego
 *	Classe que representa um topico no sistema de noticias.
 */
@Entity
@Table(name="topico")
public class Topico {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;//id que representa o topico no banco
	private String nome;//nome do topico.
	
	
	public Topico() {
		super();
	}

	//Getters e Setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
	
}	
